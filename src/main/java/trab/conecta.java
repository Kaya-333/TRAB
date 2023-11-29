package trab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conecta {
	private static String URL = "jdbc:postgresql://localhost:1309/testeguilherme";
	private static String USER = "postgres";
	private static String PASSWORD = "cloclo123";
	
	static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver do PostgreSQL não encontrado", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
