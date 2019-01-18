package servlets;

public class PlayerObject{
    private String id;
    private String player_name;

    public PlayerObject(String id, String player_name) {
        this.id = id;
        this.player_name = player_name;
    }
    public String id(){return id;}
    public String player_name(){return player_name;}
    @Override
    public String toString(){
    return new StringBuilder(id)
      .append(" | ").append(player_name)
      .toString();
  }
}
