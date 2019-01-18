package servlets;

import java.util.List;
import java.util.ArrayList;

import webroot.resources.Player;
import webroot.resources.PokerHand;
import webroot.resources.HandInfo;
import webroot.resources.Street;

import org.json.JSONArray;
import org.json.JSONObject;

public class PokerParser {

/*  public static HandInfo parse(String json) {
    JSONArray jsonArray = new JSONArray(json);
    HandInfo handInfo = new HandInfo();
  } */

  public static List<Player> parse(String json) {

    JSONArray jsonArray = new JSONArray(json);
    List<Player> players = new ArrayList<>();
    List<List<Street>> streetList = new ArrayList<>();


    for(int i = 0; i < jsonArray.length(); i++) {

      JSONObject jsonObject = jsonArray.getJSONObject(i);

      String location = jsonObject.getString("location");
      String gameType = jsonObject.getString("gameType");
      int smallBlind = jsonObject.getInt("smallBlind");
      int bigBlind = jsonObject.getInt("bigBlind");
      HandInfo handInfo = new HandInfo(location, gameType, bigBlind, smallBlind);

      String name = jsonObject.getString("name");
      String stack = jsonObject.getString("stack");
      String position = jsonObject.getString("position");
      String card1 = jsonObject.getString("card1");
      String card2 = jsonObject.getString("card2");

      players.add(new Player(name, stack, position, card1, card2));
    }
    return players;
  }
}
