package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
 private static Connection connection ;
 private static DBconnection instance ;

 private DBconnection(Connection connection) {
	this.connection = connection ;
	
}

 public static Connection getconnection() {
	 if (instance == null ) { 
		
		try {
			instance = new DBconnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/week10_Vehicules", "root", "PromineoTech2022")) ;
			System.out.println("Connection opened succefully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	return DBconnection.connection ;
 }
 }
