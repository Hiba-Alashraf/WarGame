/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hibaa
 */
public class Main {
    private static final int MINIMUM_LENGTH = 4;
       public static boolean isValidLength (ArrayList<Player> warPlayerList, String name)
    {
        return name.length()>=MINIMUM_LENGTH;
    }
  
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("WAR GAME ");
        
        int allCards = Suit.values().length * Rank.values().length;
    
        ArrayList<Card> cards = CardGenerator.generate();

        GroupOfCards mainDeck = new GroupOfCards(allCards, cards);

        mainDeck.shuffle();

        ArrayList<Card> group1 = new ArrayList<>();
        ArrayList<Card> group2 = new ArrayList<>();

        for(int i=0; i<allCards; i++) {
            if(i<allCards/2){
                group1.add(cards.get(i));
            } else {
                group2.add(cards.get(i));
            }
        }

        GroupOfCards deck1 = new GroupOfCards(group1.size(), group1);
        GroupOfCards deck2 = new GroupOfCards(group2.size(), group2);

        // PLAYER Initialize
        ArrayList<Player> PlayerList = new ArrayList<>();
        
        Scanner scn = new Scanner(System.in);
        String playerName;
        
        while( PlayerList.size() <2 ){
           
            System.out.println("Enter your Name Please:");
            playerName = scn.next();
            
            

            if( playerName.length()> 0 && isValidLength(PlayerList, playerName) ){
                if(PlayerList.isEmpty()){
                    Player wp = new Player(playerName, 0, deck1 );
                    PlayerList.add(wp);
                    wp.play();
                } else {
                    Player wp = new Player(playerName, 0, deck2 );
                    PlayerList.add(wp);
                    wp.play();
                }
                
            }  
            else{System.out.println("invalid,name should be at least 4 leeters ");}

        }

        if( PlayerList.size() == 2 ){
            
   
            
            WarGame war = new WarGame("WAR");
            
            System.out.println("Initializing... "+ war.getName() );
            
            war.setPlayers(PlayerList);
            
            System.out.println("---------------------------------------------------");
            
            try {
                
                war.play();
                
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        }
        else System.out.println("the game needs two players");
     
    }
  
   }