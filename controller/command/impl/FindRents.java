package by.epam.tr.lesson14.controller.command.impl;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.controller.command.Command;
import by.epam.tr.lesson14.service.ProductService;
import by.epam.tr.lesson14.service.exception.ServiceException;
import by.epam.tr.lesson14.service.factory.ServiceFactory;
import by.epam.tr.lesson14.util.Util;

public class FindRents implements Command {
	@Override
	public String execute(String request) {
		String response = null;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();		
		Set<Rent> rents = new HashSet<>();
		
		Date rentDateFrom = Util.parseRentDateFrom(request);
		Date rentDateTo = Util.parseRentDateTo(request);
		
		try {
			rents = productService.findRents(rentDateFrom, rentDateTo);
			
			if (rents.size() != 0) {
				response = Util.decomposeRents(rents);
			}			
		} catch (ServiceException e) {
			response = "Error duiring finding rents!";
			Logger logger = Logger.getGlobal();
			logger.log(Level.SEVERE, response, e);
		}		
		return response;
	}
}
