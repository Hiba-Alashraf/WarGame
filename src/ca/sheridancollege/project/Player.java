/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Player {
    
    private int score;
    // private ArrayList<Card> playerCard;
    private GroupOfCards groupOfCards;
    

    private String name; //the unique name for this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     * @param score
     * @param groupOfCards
     */
    public Player(String name){
          this.name=name;
    }
    public Player(String name, int score, GroupOfCards groupOfCards) {
        this.name=name;
        this.score = score;
        this.groupOfCards = groupOfCards;
    }



    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     * @return 
     */
     public int getScore() {
        return score;
    }

    public GroupOfCards getGroupOfCards() {
        return groupOfCards;
    }

    public void setGroupOfCards(GroupOfCards groupOfCards) {
        this.groupOfCards = groupOfCards;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void play(){
        System.out.println( getName() + " joined the game..." );
    }

 
    @Override
    public String toString() {
        return "WarPlayer [groupOfCards=" + groupOfCards.getCards() + ", score=" + score + "]";
    }

}
