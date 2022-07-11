import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionString = "jdbc:mysql://localhost:3306/week10_Vehicules" ;
		String SELECT_QUERY = "select * from vehicules where car_id = ?" ;
		String INSERT_QUERY = "insert into vehicules (make_name,model_name,car_year,price,color,vin) values (?,?,?,?,?,?)" ;
		
		String DELETE_QUERY = "delete from vehicules where car_id = ?" ;
		
		Scanner scanner = new Scanner(System.in) ;
		try {
			Connection conn = DriverManager.getConnection(connectionString, "root", "PromineoTech2022");
			System.out.println("Connection succefully");
	        System.out.println("1 - Select") ; 
	        System.out.println("2 - Insert") ; 
	        System.out.println("3 - Update") ; 
	        System.out.println("4 - Delete") ; 
	        System.out.println("Please choose one option") ; 
	        int option = scanner.nextInt() ;
	        switch (option) {
	        case 1 :
	        	System.out.println("Please enter the vehicule id "); 
	        	int carId = scanner.nextInt() ;
	        	PreparedStatement ps = conn.prepareStatement(SELECT_QUERY) ;
	        	 ps.setLong(1, carId);
	        	 ResultSet rs = ps.executeQuery() ;
	        	 
	        	while(rs.next()) { 
	   		   System.out.println("car_id: " + rs.getInt(1) + " Make_name " + rs.getString(2) + " Model_name: " + rs.getString(3) + " car_year: " + rs.getDate(4) +  " Price: " + rs.getBigDecimal(5) + "Color" + rs.getString(6) +  " VIN: " + rs.getString(7) );
	   		    } 
	        	 
	        	break ;
	        case 2 :
	        	System.out.println("Please Insert vehicule Info ");
	        	System.out.print("make name");
	        	String name = scanner.next() ;
	        	System.out.print("model name");
	        	String model = scanner.next() ;
	        	System.out.print("car year");
	        	String car_year = scanner.next() ;
	        	System.out.print("price");
	        	String price = scanner.next();
	        	System.out.print("color");
	        	String color = scanner.next();
	        	System.out.print("vin");
	        	String vin = scanner.next();
	        	
	        	
	        	PreparedStatement ps2 = conn.prepareStatement(INSERT_QUERY) ;
	   		    ps2.setString(1, name);
	   		    ps2.setString(2, model);
	   		    ps2.setString(3, car_year);
	   		    ps2.setString(4, price);
	   		    ps2.setString(5, color);
	   		    ps2.setString(6, vin); 
	   		    int rs2 = ps2.executeUpdate() ;
	   		    System.out.println("vehicule inserted ");
	        	
	        	break ;
	        case 3 :
	        	System.out.println("Please choose the vehicule id ");
	        	int veh_id = scanner.nextInt() ;
	        	PreparedStatement ps0 = conn.prepareStatement(SELECT_QUERY) ;
	        	 ps0.setLong(1, veh_id);
	        	 ResultSet rs0 = ps0.executeQuery() ;
	        	 if (!rs0.next()) {
	        		 System.out.println("No Vehicule exist") ;
	        	 }
	        	 else {
	        	System.out.println("Please choose the vehicule column you want to update");
	        	 System.out.println("1 - make name") ; 
	 	        System.out.println("2 - model name") ; 
	 	        System.out.println("3 - year") ; 
	 	        System.out.println("4 - price") ;
	 	       System.out.println("5 - car color") ; 
	 	        System.out.println("6 - VIN") ;
	 	       System.out.println("Please choose one option") ; 
		        int option2 = scanner.nextInt() ;
		       
		    	
	        	if (option2 == 1 ) {
	        		String UPDATE_QUERY = "update vehicules set  make_name = ? where car_id = ? " ;
	        		 PreparedStatement ps3 = conn.prepareStatement(UPDATE_QUERY) ;
	        		System.out.println("Please enter the new make name: ") ;
	        		 String makeName = scanner.next() ;
	        	
	        		 ps3.setString(1, makeName);
	        		 ps3.setLong(2, veh_id); 
	        		 int rs3 = ps3.executeUpdate() ;
	        		 System.out.println("vehicule updated ");
	        		 }
	        		 else if (option2 == 2)  {
	        			 String UPDATE_QUERY = "update vehicules set  model_name = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = conn.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new model name: ") ;
		        		 String modelName = scanner.next() ;
		        		
		        		 ps3.setString(1, modelName);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else if (option2 == 3)  {
	        			 String UPDATE_QUERY = "update vehicules set  car_year = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = conn.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new car year: ") ;
		        		 String carYear = scanner.next() ;
		        	
		        		 ps3.setString(1, carYear);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else if (option2 == 4)  {
	        			 String UPDATE_QUERY = "update vehicules set  price = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = conn.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new car price: ") ;
		        		 String carPrice = scanner.next() ;
		        	
		        		 ps3.setString(1, carPrice);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else if (option2 == 5)  {
	        			 String UPDATE_QUERY = "update vehicules set  color = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = conn.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new car color: ") ;
		        		 String carColor = scanner.next() ;
		        		
		        		 ps3.setString(1, carColor);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else if (option2 == 6)  {
	        			 String UPDATE_QUERY = "update vehicules set  vin = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = conn.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new car VIN: ") ;
		        		 String carVin = scanner.next() ;
		        		
		        		 ps3.setString(1, carVin);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else {
	        			 System.out.println("Please enter a valide choice ") ;
	        		 }}
	        	break ;
	        	
	        case 4 :
	        	
	        	System.out.println("Please enter the vehicule id you want to delete"); 
	        	int id = scanner.nextInt() ;
	        	PreparedStatement ps5 = conn.prepareStatement(SELECT_QUERY) ;
	        	 ps5.setLong(1, id);
	        	 ResultSet rs5 = ps5.executeQuery() ;
	        	 if (!rs5.next()) {
	        		 System.out.println("No Vehicule exist") ;
	        	 }
	        	 else {
	        	PreparedStatement ps4 = conn.prepareStatement(DELETE_QUERY) ;
	        	 ps4.setLong(1, id);
	        	 int rs4 = ps4.executeUpdate() ;
		   		 System.out.println("vehicule deleted ");
	        	 }
	        	break ;
	        default :
	        	System.out.println("Please enter one option between 1 to 4");       	     		
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}}
