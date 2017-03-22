package by.epam.tr.lesson14.util;

import java.sql.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.controller.command.Command;

public class Util {
	private static String parse(String text, String regexp) {
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(text);
		String result = null;
		
		if (m.find()) {
			result = m.group(1);
		}
		return result;
	}
	
	public static String parseCommand(String text) {		
		return parse(text, Command.commandParam + Command.paramValueDelimiter + Command.paramPattern);
	}
	
	public static Long parseProductId(String text) {
		return Long.parseLong(parse(text, Command.productIdParam + Command.paramValueDelimiter + Command.paramPattern));
	}
	
	public static Product parseProduct(String text) {
		Long productId = Long.parseLong(parse(text, Command.productIdParam + Command.paramValueDelimiter + Command.paramPattern));
		String productName = parse(text, Command.productNameParam + Command.paramValueDelimiter + Command.paramPattern);
		int productPrisePerDay = Integer.parseInt(parse(text, Command.productPrisePerDayParam + Command.paramValueDelimiter + Command.paramPattern));
		int productAmount = Integer.parseInt(parse(text, Command.productAmountParam + Command.paramValueDelimiter + Command.paramPattern));
		
		Product product = new Product(productId, productName, productPrisePerDay, productAmount);
		
		return product;
	}
	
	public static Rent parseRent(String text) {
		Long rentId = Long.parseLong(parse(text, Command.rentIdParam + Command.paramValueDelimiter + Command.paramPattern));
		Date rentDateFrom = Date.valueOf(parse(text, Command.rentDateFromParam + Command.paramValueDelimiter + Command.paramPattern));
		Date rentDateTo = null;
		String s = parse(text, Command.rentDateToParam + Command.paramValueDelimiter + Command.paramPattern);
		
		if (!s.equals("null")) {
			rentDateTo = Date.valueOf(s);			
		}
		
		Rent rent = new Rent(rentId, rentDateFrom, rentDateTo, parseProduct(text));
		
		return rent;
	}
	
	public static Date parseRentDateFrom(String text) {
		return Date.valueOf(parse(text, Command.rentDateFromParam + Command.paramValueDelimiter + Command.paramPattern));
	}
	
	public static Date parseRentDateTo(String text) {
		return Date.valueOf(parse(text, Command.rentDateToParam + Command.paramValueDelimiter + Command.paramPattern));
	}
	
	public static String decomposeCommand(String commandName) {
		return Command.commandParam + Command.paramValueDelimiter + commandName;
	}
	
	public static String decomposeProductId(Long productId) {
		return Command.productIdParam + Command.paramValueDelimiter + productId;
	}
	
	public static String decomposeProductId(Long productId, String commandName) {
		return Command.commandParam + Command.paramValueDelimiter + commandName + Command.paramDelimiter + decomposeProductId(productId);
	}
	
	public static String decomposeProduct(Product product) {
		return Command.paramDelimiter + Command.productIdParam + Command.paramValueDelimiter + product.getProductId() + Command.paramDelimiter + Command.productNameParam + Command.paramValueDelimiter + product.getName() + Command.paramDelimiter + Command.productPrisePerDayParam + Command.paramValueDelimiter + product.getPrisePerDay() + Command.paramDelimiter + Command.productAmountParam + Command.paramValueDelimiter + product.getAmount();
	}
	
	public static String decomposeProduct(Product product, String commandName) {
		return Command.commandParam + Command.paramValueDelimiter + commandName + Command.paramDelimiter + decomposeProduct(product);
	}
	
	public static String decomposeDates(Date dateFrom, Date dateTo) {
		return Command.rentDateFromParam + Command.paramValueDelimiter + dateFrom.toString() + Command.paramDelimiter + Command.rentDateToParam + Command.paramValueDelimiter + dateTo.toString();
	}
	
	public static String decomposeDates(Date dateFrom, Date dateTo, String commandName) {
		return Command.commandParam + Command.paramValueDelimiter + commandName + Command.paramDelimiter + decomposeDates(dateFrom, dateTo);
	}
	
	public static String decomposeProducts(Set<Product> products) {
		String result = "";
		
		for (Product product : products) {
			result += Command.productIdParam + Command.paramValueDelimiter + product.getProductId() + Command.paramDelimiter + Command.productNameParam + Command.paramValueDelimiter + product.getName() + Command.paramDelimiter + Command.productPrisePerDayParam + Command.paramValueDelimiter + product.getPrisePerDay() + Command.paramDelimiter + Command.productAmountParam + Command.paramValueDelimiter + product.getAmount() + Command.objectDelimiter;
		}
		return result;
	}
	
	public static String decomposeProducts(Set<Product> products, String commandName) {
		String result = Command.commandParam + Command.paramValueDelimiter + commandName + Command.paramDelimiter;
		
		return result + decomposeProducts(products);
	}
	
	public static String decomposeRent(Rent rent) {
		return Command.productIdParam + Command.paramValueDelimiter + rent.getProduct().getProductId() + Command.paramDelimiter + Command.productNameParam + Command.paramValueDelimiter + rent.getProduct().getName() + Command.paramDelimiter + Command.productPrisePerDayParam + Command.paramValueDelimiter + rent.getProduct().getPrisePerDay() + Command.paramDelimiter + Command.productAmountParam + Command.paramValueDelimiter + rent.getProduct().getAmount() + Command.paramDelimiter + Command.rentIdParam + Command.paramValueDelimiter + rent.getRentId() + Command.paramDelimiter + Command.rentDateFromParam + Command.paramValueDelimiter + rent.getDateFrom() + Command.paramDelimiter + Command.rentDateToParam + Command.paramValueDelimiter + rent.getDateTo();
	}
	
	public static String decomposeRent(Rent rent, String commandName) {
		return Command.commandParam + Command.paramValueDelimiter + commandName + Command.paramDelimiter + decomposeRent(rent);
	}
	
	public static String decomposeRents(Set<Rent> rents) {
		String result = "";
		
		for (Rent rent : rents) {
			result += Command.productIdParam + Command.paramValueDelimiter + rent.getProduct().getProductId() + Command.paramDelimiter + Command.productNameParam + Command.paramValueDelimiter + rent.getProduct().getName() + Command.paramDelimiter + Command.productPrisePerDayParam + Command.paramValueDelimiter + rent.getProduct().getPrisePerDay() + Command.paramDelimiter + Command.productAmountParam + Command.paramValueDelimiter + rent.getProduct().getAmount() + Command.paramDelimiter + Command.rentIdParam + Command.paramValueDelimiter + rent.getRentId() + Command.paramDelimiter + Command.rentDateFromParam + Command.paramValueDelimiter + rent.getDateFrom() + Command.paramDelimiter + Command.rentDateToParam + Command.paramValueDelimiter + rent.getDateTo() + Command.objectDelimiter;
		}
		return result;
	}
	
	public static String decomposeRents(Set<Rent> rents, String commandName) {
		String result = Command.commandParam + Command.paramValueDelimiter + commandName;
		
		return result + decomposeRents(rents);
	}	
}
