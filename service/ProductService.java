package by.epam.tr.lesson14.service;

import java.sql.Date;
import java.util.Set;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.service.exception.ServiceException;

public interface ProductService {
	int addProduct(Product product) throws ServiceException;
	int deleteProduct(long productId) throws ServiceException;
	int addRent(Rent rent) throws ServiceException;
	int closeRent(Rent rent) throws ServiceException;
	Set<Product> findProducts() throws ServiceException;
	Set<Rent> findRents(Date dateFrom, Date dateTo) throws ServiceException;
}
