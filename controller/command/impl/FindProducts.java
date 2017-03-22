package by.epam.tr.lesson14.controller.command.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.controller.command.Command;
import by.epam.tr.lesson14.service.ProductService;
import by.epam.tr.lesson14.service.exception.ServiceException;
import by.epam.tr.lesson14.service.factory.ServiceFactory;
import by.epam.tr.lesson14.util.Util;

public class FindProducts implements Command{
	@Override
	public String execute(String request) {
		String response = null;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
		Set<Product> products = new HashSet<>();
		
		try {
			products = productService.findProducts();
			
			if (products.size() != 0) {
				response = Util.decomposeProducts(products);
			}
		} catch (ServiceException e) {
			response = "Error duiring finding rents!";
			Logger logger = Logger.getGlobal();
			logger.log(Level.SEVERE, response, e);
		}		
		return response;
	}

}
