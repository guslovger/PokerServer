package servlets;

public class PokerPlayerObject{
    private String id;
    private String player_name;
    private String stack;
    private String pos;
    private String card1;
    private String card2;

    public PokerPlayerObject(String id, String player_name, String stack, String pos, String card1, String card2) {
        this.id = id;
        this.player_name = player_name;
        this.stack = stack;
        this.pos = pos;
        this.card1 = card1;
        this.card2 = card2;
    }
    public String id(){return id;}
    public String player_name(){return player_name;}
    public String stack(){return stack;}
    public String pos(){return pos;}
    public String card1(){return card1;}
    public String card2(){return card2;}

    @Override
    public String toString(){
    return new StringBuilder(id)
      .append(" | ").append(player_name)
      .toString();
  }
}
