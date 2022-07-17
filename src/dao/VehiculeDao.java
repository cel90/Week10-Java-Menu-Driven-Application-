package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import Entity.Vehicule;

// grab data from database 
public class VehiculeDao {
	// String connectionString = "jdbc:mysql://localhost:3306/week10_Vehicules" ;

	private Connection connection ;
	private final String SELECT_QUERY = "select * from vehicules where car_id = ?" ;
	private final String INSERT_QUERY = "insert into vehicules (make_name,model_name,car_year,price,color,vin) values (?,?,?,?,?,?)" ;
	private final String DELETE_QUERY = "delete from vehicules where car_id = ?" ;
	
	public VehiculeDao() {
		 connection = DBconnection.getconnection() ;
	 }
	public Vehicule getVehicule (int car) throws SQLException {
		//Connection conn = DriverManager.getConnection(connectionString, "root", "PromineoTech2022");
		// System.out.println("Connection succefully");
		final PreparedStatement ps = connection.prepareStatement(SELECT_QUERY) ;
   	 ps.setInt(1, car);
   	 ResultSet rs = ps.executeQuery() ;
    
   	if (!rs.next()) {
   		return null ;
   		
   	}
   	else {
	return new Vehicule(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)) ;
	}
	}
	public Vehicule insertVehicule (String name, String model, String car_year, String price, String color, String vin) throws SQLException {
		
		PreparedStatement ps =connection.prepareStatement(INSERT_QUERY) ;
		    ps.setString(1, name);
		    ps.setString(2, model);
		    ps.setString(3, car_year);
		    ps.setString(4, price);
		    ps.setString(5, color);
		    ps.setString(6, vin);
		     ps.executeUpdate() ;
   		    System.out.println("vehicule inserted ");
			return null;
			
		
	}
	public Vehicule DeleteVehicule (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_QUERY) ;
	   	 ps.setInt(1, id);
	   	 ps.executeUpdate() ;
		
		return null;
		
	}
	
	

}
