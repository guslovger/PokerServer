package webroot.resources;

import java.util.ArrayList;
import java.util.List;

public class PokerHand {

    private HandInfo handInfo; //Overview info of hand
    public static List<Player> playerList = new ArrayList<>(); //The players playing the hand
    public static List<Street> streetList = new ArrayList<>(); //What happened in the different streets of the hand
    public static List<Card> communityCards = new ArrayList<>(); //The community cards the dealer puts on the table
    public static List<List<Street>> listOfStreets = new ArrayList<>();
    public static List<String> communityCardList = new ArrayList<>();

    //Förenklad konstruktor så att den passar session-klassen, istället för tvärtom pga tidsbrist
    public PokerHand(HandInfo handInfo, List<Player> playerList,
                     List<List<Street>> listOfStreets, List<String> communityCardList){
        this.handInfo = handInfo;
        this.playerList = playerList;
        this.listOfStreets = listOfStreets;
        this.communityCardList = communityCardList;
    }

    @Override
    public String toString() {
        return handInfo.toString() + "  " + playerList + "  " + listOfStreets + "  " + communityCardList;
    }
/*
    public PokerHand(HandInfo handInfo, ArrayList<Player> playerList,
                     ArrayList<Street> streetList, ArrayList<Card> communityCards){
        this.handInfo = handInfo;
        this.playerList = playerList;
        this.streetList = streetList;
        this.communityCards = communityCards;
    }*/

    public void printPokerHand(){
        System.out.println(" ");
        System.out.println(handInfo.toString());
        for (Player p : playerList) {
            System.out.println(p);
        }
        System.out.println(" ");
        for (Street s : streetList) {
            System.out.println(s.toString());
        }
        System.out.println("===================");
        System.out.println(" ");
    }
}
