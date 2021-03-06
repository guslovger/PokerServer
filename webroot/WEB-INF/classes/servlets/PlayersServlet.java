package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;
import java.io.BufferedReader;
import java.sql.*;
import java.util.List;
import org.json.*;

public class PlayersServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
      System.out.println("doPost() " + request);
      
      StringBuffer jb = new StringBuffer();
      JSONObject jsonObject = new JSONObject();
      String line = null;
      try {
          BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null)
        jb.append(line);
        } catch (Exception e) { /*report an error*/ }

        try {
        jsonObject =  HTTP.toJSONObject(jb.toString());
        } catch (JSONException e) {
            // crash and burn
        throw new IOException("Error parsing JSON request string");
        }
      
      System.out.print(jsonObject);
     
  }
    
    
      // ur rqeuest hämta JSON
      // ur JSON , parsa ut en pokerhand
      // spara pokerhanden i db
      // skicka "OK"
    

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
      request.setCharacterEncoding(UTF_8.name());
      response.setContentType("application/json;charset=" + UTF_8.name());

    PrintWriter out =
      new PrintWriter(new OutputStreamWriter(response.getOutputStream(),
                                             UTF_8), true);


    List<PlayerObject> playersList = new PlayersDB().getPlayers();
    JSONArray players = new JSONArray();
 //   JSONObject players = new JSONObject();

    for(PlayerObject p : playersList) {
        JSONObject jPlayer = new JSONObject();
        jPlayer.put("id", p.id());
        jPlayer.put("playername" , p.player_name());
        players.put(jPlayer);
    }

    //System.out.println(players.toString());

    out.println(players.toString(2));
    //System.out.println("Äntligen(tm)");
    out.close();
  }
}
