package com.freetuition.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.freetuition.dbutil.PostresqlConnection;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Login;

public class LoginDAOImpl {
	// --------------------------------------Customer Log In
	// -------------------------------------

	public Login letEmployeeLogin(String login, String password) throws BusinessException, ClassNotFoundException {
		Login lgn = null;
			try (Connection connection = PostresqlConnection.getConnection()) {
				String sql = "select employee_id from freetuition.login where login=? AND password=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, login);
				preparedStatement.setString(2, password);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {

					lgn = new Login();
					lgn.setLogin(login);
					lgn.setPassword(password);
					lgn.setId(resultSet.getInt("employee_id"));

				} else {

					throw new BusinessException("No customer found with such login or password");
				}
			} catch (SQLException e) {
				
				System.out.println(e);

				throw new BusinessException("Internal error occured contact admin ");
			}
		return lgn;
	}
	// -----------------------------------Create Customer AND Create CustomerLogin

	public int createLogin(Login lgn) throws BusinessException, ClassNotFoundException {
		int c = 0;
		try (Connection connection = PostresqlConnection.getConnection()) {

			String sql = "insert into freetuition.login (login, password) values(?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, lgn.getLogin());
			preparedStatement.setString(2, lgn.getPassword());

			c = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e);

			throw new BusinessException("Some internal error occured. Please contact admin");
		}
		return c;
	}

}
