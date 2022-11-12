package BDUtils;

import java.sql.*;
import java.util.ResourceBundle;

public class DButil {
	
	 	private static String url;
	    private static String driverName;
	    private static String username;
	    private static String password;
	    
	    
	    static {
	        
	        ResourceBundle rb= ResourceBundle.getBundle("dbdetails");
	        
	        url= rb.getString("db.url");
	        driverName= rb.getString("db.drivername");
	        username= rb.getString("db.username");
	        password= rb.getString("db.password");
	        
	        
	        
	    }
	    
	    
	    public static Connection provideConnection() {
	        
	        Connection conn = null;
	        
	        
	        try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
//			String url= "jdbc:mysql://localhost:3306/bankingsystem";
			
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        
	        
	        
	        return conn;
	    }
}
