package by.epam.tr.lesson14.controller.command.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam.tr.lesson14.controller.command.Command;
import by.epam.tr.lesson14.service.ProductService;
import by.epam.tr.lesson14.service.exception.ServiceException;
import by.epam.tr.lesson14.service.factory.ServiceFactory;
import by.epam.tr.lesson14.util.Util;

public class DeleteProduct implements Command {
	@Override
	public String execute(String request) {
		String response = null;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
		
		Long productId = Util.parseProductId(request);
		
		try {
			int count = productService.deleteProduct(productId);
			
			if (count != 0) {
				response = Util.decomposeProductId(productId);
			}			
		} catch (ServiceException e) {
			response = "Error duiring deleting product!";
			Logger logger = Logger.getGlobal();
			logger.log(Level.SEVERE, response, e);
		}		
		return response;
	}

}
