package by.epam.tr.lesson14.dao;

import java.sql.Date;
import java.util.Set;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.dao.exception.DAOException;

public interface ProductDAO {
	int addProduct(Product product) throws DAOException;
	int deleteProduct(long productId) throws DAOException;
	int addRent(Rent rent) throws DAOException;
	int closeRent(Rent rent) throws DAOException;
	Set<Product> findProducts() throws DAOException;
	Set<Rent> findRents(Date dateFrom, Date dateTo) throws DAOException;
}
