package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import org.json.*;

public class LocationServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
      request.setCharacterEncoding(UTF_8.name());      
      response.setContentType("application/json;charset=" + UTF_8.name());
      
    PrintWriter out =
      new PrintWriter(new OutputStreamWriter(response.getOutputStream(),
                                             UTF_8), true);
      
        
    List<LocationObject> locationList = new LocationDB().getLocation();        
    JSONArray location = new JSONArray();
 //   JSONObject players = new JSONObject();
        
    for(LocationObject l : locationList) {
        JSONObject jLocation = new JSONObject();
        jLocation.put("id", l.id());
        jLocation.put("playername" , l.location_name());
        location.put(jLocation);    
    }
  
    //System.out.println(players.toString());
    
    out.println(location.toString(2));   
    //System.out.println("Äntligen(tm)");
    out.close();
  }
}