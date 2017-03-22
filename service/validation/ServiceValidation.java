package by.epam.tr.lesson14.service.validation;

import java.sql.Date;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.bean.Rent;

public class ServiceValidation {
	public static boolean isValidProduct(Product product) {
		if (product == null || product.getProductId() <= 0 || product.getPrisePerDay() < 0 || product.getName() == null || product.getName().isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidRent(Rent rent) {
		if (rent == null || rent.getRentId() <= 0 || !isValidProduct(rent.getProduct()) || rent.getDateFrom() == null) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidProductId(long productId) {
		if (productId <= 0) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidDateFrom(Date dateFrom) {
		if (dateFrom == null) {
			return false;
		}
		return true;
	}
}
