package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Entity.Vehicule;
import dao.DBconnection;
import dao.VehiculeDao;

public class Menu {
	private Scanner scanner = new Scanner(System.in) ;
	private List<String> menuOptions = Arrays.asList("Select", "Insert", "Update", "Delete", "Exit") ; 
	private VehiculeDao vDao = new VehiculeDao() ;
	private Connection connection ;
	public Menu () {
		 connection = DBconnection.getconnection() ;
	 }
	public void start() {
		int option = 0  ;
		
		do {
			
		
		 printMenu() ;
		 option = scanner.nextInt() ; 
    
		
			try {
				
				switch (option) {
				case 1 :
					selectVeh() ;
					break ;
				case 2 :
				    insertVeh();
				
					break ;
				case 3 :
					updateVeh() ;
					
					
					break ;
					
				case 4 :
					
					deleteVeh() ;
					
					break ;
				case 5 : 
					System.out.println("Bye Bye !!");
					connection.close();
				
					return ;
				default :
					System.out.println("Please enter one option between 1 to 4");       	     		
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		//System.out.println("Press enter to continue") ; 
		//scanner.nextLine() ;
		}
		while ( option != 1 || option != 2 || option != 3 || option != 4 || option != 5 ) ;
		}
		
		private void printMenu() {
			System.out.println("----------------------------");
			for (int i=0 ; i < menuOptions.size() ; i++ ) {
				
			System.out.println(i+1 + "-"  + menuOptions.get(i) ) ; 
	        }
			System.out.println("----------------------------");
	        System.out.println("Please choose one option") ; 
	         
		}
		private void selectVeh() throws SQLException {
			System.out.println("Please enter the vehicule id "); 
        	int carId = scanner.nextInt();
        	Vehicule v = vDao.getVehicule(carId);
        	
        	if (v == null) {
        		System.out.println("No Vehicule exist");
        	}
        	else {
        		System.out.println(v.getVehId() + "," + v.getMakeName() + "," + v.getModelName() + "," + v.getVehYear() + "," + v.getVehPrice() + "," + v.getVehColor() + "," + v.getVehVin());
        		
        	//}
		} }
		
		private void insertVeh() throws SQLException {
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
        	Vehicule v = vDao.insertVehicule(name, model, car_year, price, color, vin);
		}
		private void updateVeh() throws SQLException {
			System.out.println("Please choose the vehicule id ");
        	int veh_id = scanner.nextInt() ;
        	Vehicule v = vDao.getVehicule(veh_id);
        	if (v == null) {
        		System.out.println("No Vehicule exist");
        	}
        	else {
        		System.out.println(" Vehicule exist");
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
	        		 PreparedStatement ps3 = connection.prepareStatement(UPDATE_QUERY) ;
	        		System.out.println("Please enter the new make name: ") ;
	        		 String makeName = scanner.next() ;
	        	
	        		 ps3.setString(1, makeName);
	        		 ps3.setLong(2, veh_id); 
	        		 int rs3 = ps3.executeUpdate() ;
	        		 System.out.println("vehicule updated ");
	        		 }
	        		 else if (option2 == 2)  {
	        			 String UPDATE_QUERY = "update vehicules set  model_name = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = connection.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new model name: ") ;
		        		 String modelName = scanner.next() ;
		        		
		        		 ps3.setString(1, modelName);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else if (option2 == 3)  {
	        			 String UPDATE_QUERY = "update vehicules set  car_year = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = connection.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new car year: ") ;
		        		 String carYear = scanner.next() ;
		        	
		        		 ps3.setString(1, carYear);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else if (option2 == 4)  {
	        			 String UPDATE_QUERY = "update vehicules set  price = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = connection.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new car price: ") ;
		        		 String carPrice = scanner.next() ;
		        	
		        		 ps3.setString(1, carPrice);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else if (option2 == 5)  {
	        			 String UPDATE_QUERY = "update vehicules set  color = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = connection.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new car color: ") ;
		        		 String carColor = scanner.next() ;
		        		
		        		 ps3.setString(1, carColor);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else if (option2 == 6)  {
	        			 String UPDATE_QUERY = "update vehicules set  vin = ? where car_id = ? " ;
		        		 PreparedStatement ps3 = connection.prepareStatement(UPDATE_QUERY) ;
	        			 System.out.println("Please enter the new car VIN: ") ;
		        		 String carVin = scanner.next() ;
		        		
		        		 ps3.setString(1, carVin);
		        		 ps3.setLong(2, veh_id);
		        		 int rs3 = ps3.executeUpdate() ;
		        		 System.out.println("vehicule updated ");
	        	                     }
	        		 else {
	        			 System.out.println("Please enter a valide choice ") ;
	        		 }
		    	
	        	
		} }
	public void deleteVeh () throws SQLException {
		System.out.println("Please enter the vehicule id you want to delete"); 
    	int id = scanner.nextInt() ;
    	Vehicule v = vDao.getVehicule(id);
    	if (v == null) {
    		System.out.println("No Vehicule exist");
    	}
    	else {
    		System.out.println(" Vehicule exist");
    		Vehicule v1 =vDao.DeleteVehicule(id) ;
    		System.out.println("Vehicule Deleted");    	
	}
	}}

