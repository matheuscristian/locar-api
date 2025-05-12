package com.locar.locar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocarApplication {
	public static void main(String[] args) {
		SpringApplication.run(LocarApplication.class, args);
	}

	public static <T> T DatabaseConnection(Function<Connection, T> processor) {
		String url = "jdbc:mysql://localhost:3306/locarbanco?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = null;

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			T t = processor.apply(conn);
			conn.close();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
