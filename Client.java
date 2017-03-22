package by.epam.tr.lesson14;

import java.sql.Date;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.controller.Controller;
import by.epam.tr.lesson14.view.View;

public class Client {
	public static void main(String[] args) {
		View view = new View();
		Controller controller = Controller.getInstance();
		Product product;
		Rent rent;
		Date dateFrom;
		Date dateTo;		
		
		view.setController(controller);
		
		//Find available products for rent
		view.findProducts();
		
		//Find all rents
		System.out.println("------------------------------------------------------------------------------------------------------------");
		dateFrom = Date.valueOf("2016-01-01");
		dateTo = Date.valueOf("2017-03-01");
		view.findRents(dateFrom, dateTo);
		
		//Add product
		System.out.println("------------------------------------------------------------------------------------------------------------");
		product = new Product(12, "Hockey stick", 3, 20);
		view.addProduct(product);
		
		//Delete product
		System.out.println("------------------------------------------------------------------------------------------------------------");
		Long productId = 12l;
		view.deleteProduct(productId);
		
		//Add rent
		System.out.println("------------------------------------------------------------------------------------------------------------");
		product = new Product(1, "Football ball", 2, 30);
		rent = new Rent(27, dateFrom, dateTo, product);
		view.addRent(rent);
		
		//Close rent
		System.out.println("------------------------------------------------------------------------------------------------------------");
		product = new Product(4, "Skates", 7, 7);
		dateFrom = Date.valueOf("2017-03-07");
		dateTo = null;
		rent = new Rent(8, dateFrom, dateTo, product);
		view.closeRent(rent);
	}
}
