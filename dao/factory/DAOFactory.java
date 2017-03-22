package by.epam.tr.lesson14.dao.factory;

import by.epam.tr.lesson14.dao.ProductDAO;
import by.epam.tr.lesson14.dao.impl.SQLProductDAO;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private final ProductDAO sqlProductImpl = new SQLProductDAO();
	
	private DAOFactory() {		
	}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	
	public ProductDAO getProductDAO(){
		return sqlProductImpl;
	}
}
