package by.epam.tr.lesson14.view;

import java.sql.Date;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.controller.Controller;
import by.epam.tr.lesson14.controller.command.Command;
import by.epam.tr.lesson14.util.Util;

public class View {
	private Controller controller;
	private static final String addProductCommand = "ADD_PRODUCT";
	private static final String deleteProductCommand = "DELETE_PRODUCT";
	private static final String addRentCommand = "ADD_RENT";
	private static final String closeRentCommand = "CLOSE_RENT";
	private static final String findProductsCommand = "FIND_PRODUCTS";
	private static final String findRentsCommand = "FIND_RENTS";

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void addProduct(Product product) {
		String request = Util.decomposeProduct(product, addProductCommand);
		String response = controller.executeTask(request);
		
		if (response == null) {
			System.out.println("Product with this id already exists!");
			return;
		}
		System.out.println("Added product: ");
		System.out.println(Util.parseProduct(response));
	};
	
	public void deleteProduct(long productId) {
		String request = Util.decomposeProductId(productId, deleteProductCommand);
		String response = controller.executeTask(request);
		
		if (response == null) {
			System.out.println("Product with this id does not exists!");
			return;
		}
		System.out.println("Deleted products with id = " + Util.parseProductId(response));
	}
	
	public void addRent(Rent rent) {
		String request = Util.decomposeRent(rent, addRentCommand);
		String response = controller.executeTask(request);
		
		if (response == null) {
			System.out.println("Rent with this id already exist!");
			return;
		}
		System.out.println("Added rent: ");
		System.out.println(Util.parseRent(response));
	}
	
	public void closeRent(Rent rent) {
		String request = Util.decomposeRent(rent, closeRentCommand);
		String response = controller.executeTask(request);
		
		if (response == null) {
			System.out.println("Rent with this id does not exist!");
			return;
		}
		System.out.println(Util.parseRent(response));
	}
	
	public void findProducts() {
		String request = Util.decomposeCommand(findProductsCommand);
		String response = controller.executeTask(request);
		
		if (response == null) {
			System.out.println("No products found!");
			return;
		}
		String[] objects = response.split(Command.objectDelimiter);
		
		System.out.println("Founded products are: ");
		
		for (String object : objects) {			
			Product product = Util.parseProduct(object);			
			System.out.println(product);
		}
	}
	
	public void findRents(Date dateFrom, Date dateTo) {
		String request = Util.decomposeDates(dateFrom, dateTo, findRentsCommand);
		String response = controller.executeTask(request);
		
		if (response == null) {
			System.out.println("No rents found!");
			return;
		}
		String[] objects = response.split(Command.objectDelimiter);
			
		System.out.println("Founded rents are: ");
			
		for (String object : objects) {
			Rent rent = Util.parseRent(object);			
			System.out.println(rent);
		}
	}
}
