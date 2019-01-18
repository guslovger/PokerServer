package servlets;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class LocationDB {

  
static Connection con;
static { 
    try {
      con = DriverManager.getConnection("jdbc:sqlite:webroot/WEB-INF/lib/PokerDatabase.db");
      }catch(SQLException sqle){
      System.err.println("Database error: " +
                  sqle.getMessage());
    }
}           
        
    public List<LocationObject>getLocation(){        
    List<LocationObject> location = new ArrayList<>();            
    try {
    Statement stm = con.createStatement();
    ResultSet rs = stm.executeQuery("SELECT * FROM locations");
    LocationObject lo = null; 
    while(rs.next()){        
      lo = new LocationObject(rs.getString("ID"), 
                          rs.getString("LOCATION_NAME"));
        
      location.add(lo);
      }
    }catch(SQLException sqle){
      System.err.println("Database error: " +
                  sqle.getMessage());
        
    }   
        
    return location;
  }
}