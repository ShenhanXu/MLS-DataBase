package com.mls.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class DatabaseApplication {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}


	public void run(String... args) throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			System.out.println("Successfully connected to the database: " + connection.getCatalog());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
