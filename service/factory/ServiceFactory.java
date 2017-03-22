package by.epam.tr.lesson14.service.factory;

import by.epam.tr.lesson14.service.ProductService;
import by.epam.tr.lesson14.service.impl.ProductServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	private final ProductService productService = new ProductServiceImpl();
	
	private ServiceFactory() {		
	}
	
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public ProductService getProductService(){
		return productService;
	}
}
