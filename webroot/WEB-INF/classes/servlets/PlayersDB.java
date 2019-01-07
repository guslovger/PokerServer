package classes.servlets;

import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class PlayersDB {

  
static Connection con;
static { 
    try {
      Connection con = DriverManager.getConnection("jdbc:sqlite:webroot/WEB-INF/lib/PokerDatabase.db");
      }catch(SQLException sqle){
      System.err.println("Database error: " +
                  sqle.getMessage());
    }
}
            
        
    public List<PlayerObject>getPlayer(){        
    List<PlayerObject> player = new ArrayList<>();            
    try {
    Statement stm = con.createStatement();
    ResultSet rs = stm.executeQuery("SELECT * FROM players");
    PlayerObject po = null; 
    while(rs.next()){        
      po = new PlayerObject(rs.getString("ID"), 
                          rs.getString("PLAYER_NAME"));
        
      players.add(po);
      }
    }catch(SQLException sqle){
      System.err.println("Database error: " +
                  sqle.getMessage());
        
    }   
        
    return player;
  }
}
