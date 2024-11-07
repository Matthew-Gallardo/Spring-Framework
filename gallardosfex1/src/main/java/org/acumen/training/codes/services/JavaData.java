package org.acumen.training.codes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class JavaData {
	private Connection conn;

    @Value("${driverClass:org.postgresql.Driver}")
	private String driverClass;
    
	@Value("${uri}")
	private String uri;

	@Value("${user}")
	private String user;

	@Value("${password}")
	private String password;

	public String getDriverClass() {
		return driverClass;
	}

	public String getUri() {
		return uri;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void loadDriver() throws InstantiationException, IllegalAccessException {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void openConn() {
		try {
			conn = DriverManager.getConnection(uri, user, password);
			conn.setAutoCommit(false);
			System.out.println("successful connection.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Company> getAllCompanyInfo() {
		List<Company> cmp = new ArrayList<>();
		try (Statement stmt = conn.createStatement()) {
			String sql = "SELECT * FROM company";
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				Company company = new Company();
				company.setId(result.getInt("id"));
				company.setName(result.getString("name"));
				company.setAddress(result.getString("address"));
				cmp.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cmp;
	}
}
