package by.epam.tr.lesson14.service.impl;

import java.sql.Date;
import java.util.Set;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.dao.ProductDAO;
import by.epam.tr.lesson14.dao.exception.DAOException;
import by.epam.tr.lesson14.dao.factory.DAOFactory;
import by.epam.tr.lesson14.service.ProductService;
import by.epam.tr.lesson14.service.exception.ServiceException;
import by.epam.tr.lesson14.service.validation.ServiceValidation;

public class ProductServiceImpl implements ProductService{

	@Override
	public int addProduct(Product product) throws ServiceException {
		int count = 0;
		
		if (!ServiceValidation.isValidProduct(product)) {
			throw new ServiceException("Incorrect product");
		}
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ProductDAO productDAO = daoFactory.getProductDAO();		
		
			count = productDAO.addProduct(product);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return count;
	}

	@Override
	public int deleteProduct(long productId) throws ServiceException {
		int count = 0;
		
		if (!ServiceValidation.isValidProductId(productId)) {
			throw new ServiceException("Incorrect productId");
		}
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ProductDAO productDAO = daoFactory.getProductDAO();
		
			count = productDAO.deleteProduct(productId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return count;
	}

	@Override
	public int addRent(Rent rent) throws ServiceException {
		int count = 0;
		
		if (!ServiceValidation.isValidRent(rent)) {
			throw new ServiceException("Incorrect rent");
		}
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ProductDAO productDAO = daoFactory.getProductDAO();
			
			count = productDAO.addRent(rent);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return count;
	}

	@Override
	public int closeRent(Rent rent) throws ServiceException {
		int count = 0;
		
		if (!ServiceValidation.isValidRent(rent)) {
			throw new ServiceException("Incorrect rent");
		}
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ProductDAO productDAO = daoFactory.getProductDAO();
			
			count = productDAO.closeRent(rent);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return count;
	}

	@Override
	public Set<Product> findProducts() throws ServiceException {		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ProductDAO productDAO = daoFactory.getProductDAO();
			
			return productDAO.findProducts();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Set<Rent> findRents(Date dateFrom, Date dateTo) throws ServiceException {
		if (!ServiceValidation.isValidDateFrom(dateFrom)) {
			throw new ServiceException("Incorrect dateFrom");
		}
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ProductDAO productDAO = daoFactory.getProductDAO();
			
			return productDAO.findRents(dateFrom, dateTo);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
