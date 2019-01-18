package servlets;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class PlayersDB {


static Connection con;
static {
    try {
      con = DriverManager.getConnection("jdbc:sqlite:webroot/WEB-INF/lib/PokerDatabase.db");
      }catch(SQLException sqle){
      System.err.println("Database error: " +
                  sqle.getMessage());
    }
}

    public List<PlayerObject>getPlayers(){
    List<PlayerObject> players = new ArrayList<>();
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

    return players;
  }
}
