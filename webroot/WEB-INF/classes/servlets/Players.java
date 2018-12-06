package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;
import java.sql.*;

public class Players extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    PrintWriter out =
      new PrintWriter(new OutputStreamWriter(response.getOutputStream(),
                                             UTF_8), true);
    try {
      Connection con = DriverManager.getConnection("jdbc:sqlite:webroot/WEB-INF/lib/PokerDatabase.db");
      Statement stm = con.createStatement();
      ResultSet rs = stm.executeQuery("SELECT * FROM players");
      StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n")
        .append("<html>\n")
        .append("<head>\n")
        .append("  <title>Hello world servlet!</title>\n")
        .append("</head> \n")
        .append("<body>\n")
        .append("<ul>\n");
      while(rs.next()){
        sb.append("<li>")
          .append(rs.getString("ID"))
          .append(" - ")
          .append(rs.getString("Player_NAME"))
          .append("</li>\n");
      }
        sb.append("</ul>\n")
        .append("</body>\n")
        .append("</html>\n");
      out.println(sb.toString());
    }catch(SQLException sqle){
    out.println("<em style=\"color: red;\">Database error: " +
                  sqle.getMessage() +
                  "</em>");
    }
    out.close();
  }
  @Override
  public void init() throws ServletException {
    try{
      Class.forName("org.sqlite.JDBC");
    }catch(ClassNotFoundException cnfe){
      System.err.println("Could not load driver: "+cnfe.getMessage());
    }
  }
}
