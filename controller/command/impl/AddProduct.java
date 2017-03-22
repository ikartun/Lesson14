package by.epam.tr.lesson14.controller.command.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.controller.command.Command;
import by.epam.tr.lesson14.util.Util;
import by.epam.tr.lesson14.service.ProductService;
import by.epam.tr.lesson14.service.exception.ServiceException;
import by.epam.tr.lesson14.service.factory.ServiceFactory;

public class AddProduct implements Command{
	@Override
	public String execute(String request) {
		String response = null;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
		
		Product product = Util.parseProduct(request);
		
		try {
			int count = productService.addProduct(product);
			
			if (count != 0) {
				response = Util.decomposeProduct(product);
			}
		} catch (ServiceException e) {
			response = "Error duiring adding product!";
			Logger logger = Logger.getGlobal();
			logger.log(Level.SEVERE, response, e);
		}		
		return response;
	}
}
