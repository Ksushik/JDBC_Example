package com.skillsup.syniaeva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by osyniaeva on 9/21/17.
 */
public class DBManager {
	private Connection conn;

	public DBManager() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test",
					"sa", "");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createTable() {
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = "CREATE TABLE   REGISTRATION " +
					"(id INTEGER not NULL, " +
					" first VARCHAR(255), " +
					" last VARCHAR(255), " +
					" age INTEGER, " +
					" PRIMARY KEY ( id ))";
			st.executeUpdate(sql);
			System.out.println("Created table in given database...");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (st != null) {
				try {
					st.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void addRecords(User user) {
		PreparedStatement st = null;
		String sql = "INSERT INTO Registration " + "VALUES (?, ?, ?, ?)";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, user.getId());
			st.setString(2, user.getFirstName());
			st.setString(3, user.getLastName());
			st.setInt(4, user.getAge());
			st.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (st != null) {
				try {
					st.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public List<User> getRegistratedUsers() {
		List<User> users = new ArrayList<>();
		Statement st = null;
		try {
			st = conn.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT * FROM Registration");

			while(resultSet.next()) {
				User temp = new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(4),resultSet.getString(3));
				users.add(temp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return users;
	}

	public void closeConnection() {
		try {
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
