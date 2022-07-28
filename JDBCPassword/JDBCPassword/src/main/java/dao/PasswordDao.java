package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Password;

public class PasswordDao {
	public void savePassword(Password  password1) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO password VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, password1.getId());
			preparedStatement.setString(2, password1.getAccName());
			preparedStatement.setString(3, password1.getUserName());
			preparedStatement.setString(4, password1.getPassword());
			preparedStatement.execute();

			System.out.println("Password successfully added");
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet getPassword() {
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			 connection = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM password";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;

	}
	public ResultSet getPasswordByAccName(String accName) {
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM password WHERE accName=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accName);
			resultSet = preparedStatement.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;

	}
	public int updatePassword(Password password2) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE password SET id = ?,userName=?,password=? WHERE accName=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, password2.getId());
			preparedStatement.setString(2, password2.getUserName());
			preparedStatement.setString(3, password2.getPassword());
			preparedStatement.setString(4, password2.getAccName());
			result = preparedStatement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	public int deletePassword(String accName) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM password WHERE accName=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accName);
			result = preparedStatement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	

}
