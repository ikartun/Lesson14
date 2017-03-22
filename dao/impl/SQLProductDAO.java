package by.epam.tr.lesson14.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import by.epam.tr.lesson14.bean.Product;
import by.epam.tr.lesson14.bean.Rent;
import by.epam.tr.lesson14.dao.ProductDAO;
import by.epam.tr.lesson14.dao.exception.DAOException;

public class SQLProductDAO implements ProductDAO{
	//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	
	private Connection initConnection() throws SQLException {
		Connection  connection = DriverManager.getConnection("jdbc:oracle:thin:@xxxxxxxxxxxxxx:1521:xxxxx", "JAVA_STORE_TEST", "123456");
		connection.setAutoCommit(false);
		return connection;
	}
	
	private void closeConnection(Connection connection) throws DAOException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	}
	
	private boolean isProductExists(Product product) throws SQLException {
		Connection  connection = initConnection();
		PreparedStatement preparedStatement = null;
		
		preparedStatement = connection.prepareStatement("select count(1) from product where product_id = ?");
		preparedStatement.setLong(1, product.getProductId());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		
		if (resultSet.getInt(1) == 0) {
			return false;				
		}
		return true;
	}
	
	private boolean isRentExists(Rent rent) throws SQLException {
		Connection  connection = initConnection();
		PreparedStatement preparedStatement = null;
		
		preparedStatement = connection.prepareStatement("select count(1) from rent where rent_id = ?");
		preparedStatement.setLong(1, rent.getRentId());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		
		if (resultSet.getInt(1) == 0) {
			return false;				
		}
		return true;
	}
	
	private boolean isProductAmountAvailable(Product product) throws SQLException {
		Connection  connection = initConnection();
		PreparedStatement preparedStatement = null;
		
		preparedStatement = connection.prepareStatement("select p.amount - (select count(1) from rent r where r.product_id = p.product_id and r.date_to is null) from product p where product_id = ?");
		preparedStatement.setLong(1, product.getProductId());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		
		if (resultSet.getInt(1) > 0) {
			return true;				
		}
		return false;
	}
	
	@Override
	public int addProduct(Product product) throws DAOException {
		Connection connection = null;
		int count = 0;
		try {
			connection = initConnection();
			PreparedStatement preparedStatement = null;
			
			if (isProductExists(product)) {
				return count;
			}
			preparedStatement = connection.prepareStatement("insert into product(product_id, name, price_per_day, amount) values(?, ?, ?, ?)");
			preparedStatement.setLong(1, product.getProductId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrisePerDay());
			preparedStatement.setInt(4, product.getAmount());
			count = preparedStatement.executeUpdate();
			closeConnection(connection);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		finally {
			closeConnection(connection);
		}
		return count;
	}

	@Override
	public int deleteProduct(long productId) throws DAOException {
		Connection connection = null;
		int count = 0;
		try {
			connection = initConnection();
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connection.prepareStatement("delete from rent where product_id = ?");
			preparedStatement.setLong(1, productId);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("delete from product where product_id = ?");
			preparedStatement.setLong(1, productId);
			count = preparedStatement.executeUpdate();
			connection.commit();
			closeConnection(connection);
		} catch (SQLException e) {
			throw new DAOException(e);			
		}
		finally {
			closeConnection(connection);
		}
		return count;
	}

	@Override
	public int addRent(Rent rent) throws DAOException {
		Connection connection = null;
		int count = 0;
		try {
			connection = initConnection();
			PreparedStatement preparedStatement = null;
			
			if (isRentExists(rent)) {
				return count;
			}			
			
			if (!isProductExists(rent.getProduct())) {
				addProduct(rent.getProduct());				
			}
			if (isProductAmountAvailable(rent.getProduct())) {
				preparedStatement = connection.prepareStatement("insert into rent(rent_id, product_id, date_from, date_to) values(?, ?, ?, ?)");				
				preparedStatement.setLong(1, rent.getRentId());
				preparedStatement.setLong(2, rent.getProduct().getProductId());
				preparedStatement.setDate(3, rent.getDateFrom());
				preparedStatement.setDate(4, rent.getDateTo());
				count = preparedStatement.executeUpdate();
				}
			connection.commit();
			closeConnection(connection);
		} catch (SQLException e) {
			throw new DAOException(e);			
		}
		finally {
			closeConnection(connection);
		}
		return count;
	}

	@Override
	public int closeRent(Rent rent) throws DAOException {
		Connection connection = null;
		int count = 0;
		try {
			connection = initConnection();
			PreparedStatement preparedStatement = null;
			Date date = Date.valueOf(new Date(new java.util.Date().getTime()).toString());
			
			preparedStatement = connection.prepareStatement("update rent set date_to = ? where rent_id = ?");
			preparedStatement.setDate(1, date);
			preparedStatement.setLong(2, rent.getRentId());
			count = preparedStatement.executeUpdate();
			connection.commit();
			rent.setDateTo(date);
			closeConnection(connection);
		} catch (SQLException e) {
			throw new DAOException(e);			
		}
		finally {
			closeConnection(connection);
		}
		return count;
	}

	@Override
	public Set<Product> findProducts() throws DAOException {
		Connection connection = null;
		Set<Product> products = new HashSet<>();
		try {
			connection = initConnection();
			Statement statement = null;
			
			statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery("select p.product_id, p.name, p.price_per_day, p.amount from product p where p.amount > (select count(1) from rent where product_id = p.product_id and date_To is null)");
			while (resultSet.next()) {
				Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
				products.add(product);
			}
			closeConnection(connection);
		} catch (SQLException e) {
			throw new DAOException(e);			
		}
		finally {
			closeConnection(connection);
		}
		return products;
	}

	@Override
	public Set<Rent> findRents(Date dateFrom, Date dateTo) throws DAOException {
		Connection connection = null;
		Set<Rent> rents = new HashSet<>();
		try {
			connection = initConnection();
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connection.prepareStatement("select r.rent_id, r.date_from, r.date_to, p.product_id, p.name, p.price_per_day, p.amount from product p join rent r on (p.product_id = r.product_id) where r.date_from >= ? and r.date_To <= ?");
			preparedStatement.setDate(1, dateFrom);
			preparedStatement.setDate(2, dateTo);
			preparedStatement.executeQuery();
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Rent rent = new Rent(resultSet.getLong(1), resultSet.getDate(2), resultSet.getDate(3), new Product(resultSet.getLong(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7)));
				rents.add(rent);
			}
			closeConnection(connection);
		} catch (SQLException e) {
			throw new DAOException(e);			
		}
		finally {
			closeConnection(connection);
		}
		return rents;
	}
}
