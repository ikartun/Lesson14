package by.epam.tr.lesson14.controller.command.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.controller.command.Command;
import by.epam.tr.lesson14.service.ProductService;
import by.epam.tr.lesson14.service.exception.ServiceException;
import by.epam.tr.lesson14.service.factory.ServiceFactory;
import by.epam.tr.lesson14.util.Util;

public class CloseRent implements Command {
	@Override
	public String execute(String request) {
		String response = null;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
		
		Rent rent = Util.parseRent(request);
		
		try {
			int count = productService.closeRent(rent);
			
			if (count != 0) {
				response = Util.decomposeRent(rent);
			}			
		} catch (ServiceException e) {
			response = "Error duiring closing rent!";
			Logger logger = Logger.getGlobal();
			logger.log(Level.SEVERE, response, e);
		}		
		return response;
	}
}
