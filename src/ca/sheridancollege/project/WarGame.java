/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hiba Alashraf
 */
public class WarGame extends Game {
    
    private Player Finalwinner;
    
    ArrayList<Player> players;
    
    private final ArrayList<WarCard> warRoundCards1 = new ArrayList<>();
    private final ArrayList<WarCard> warRoundCards2 = new ArrayList<>();
    
    private GroupOfCards group1;
    private GroupOfCards group2;
    
    private ArrayList<Card> cards1 = new ArrayList<>();
    private ArrayList<Card> cards2 = new ArrayList<>();
    
    private int count1 = 0;
    private int count2 = 0;
    private int iterator = 0;
    private final int CardLimit = 5;
    private int begun1, final1, begun2, final2;
    
    private Player player1;
    private Player player2;
    
    private WarCard wCard1;
    private WarCard wCard2;
    
    private Card cd1;
    private Card cd2;

    public WarGame(String name) {
        super(name);
    }
    
    public Player getWinner() {
        return Finalwinner;
    }

    public void setWinner(Player winner) {
        this.Finalwinner = winner;
    }
    
    
    @Override
    public void play() {
        
        System.out.println(" Game is about to start");
        
        players = super.getPlayers();
        
        player1 = players.get(0);
        player2 = players.get(1);
        
        group1 = ( player1.getGroupOfCards() );
        group2 =( player2.getGroupOfCards() );

        cards1 = group1.getCards();
        cards2 = group2.getCards();

        group1.setSize(cards1.size());
        group2.setSize(cards2.size());
        
        while(!cards1.isEmpty() && !cards2.isEmpty() ) {
            
            try {
                TimeUnit.MILLISECONDS.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(WarGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("-----------------------------");
            System.out.println("ROUND NUMBER : "+(++iterator));
            
            cd1 = cards1.get( cards1.size()-1 );
            wCard1 = ((WarCard) cd1);

            cd2 = cards2.get( cards2.size()-1 );
            wCard2 = ((WarCard) cd2);
            
            System.out.println(player1.getName()+" draws card : "+cd1);
            System.out.println(player2.getName()+" draws card : "+cd2);
            
            if( enumToInt(wCard1) == enumToInt(wCard2) ) {
                            
                this.playWarRound();
                
            } else if( enumToInt(wCard1) > enumToInt(wCard2) ) {
                
                System.out.println("<<<<<<"+player1.getName()+" Won This Time>>>>>");
                cards1.add(0, wCard1);
                cards1.add(0, wCard2);
                count1++;
                if( !cards1.isEmpty() ) {
                    cards1.remove(cards1.size()-1);
                }
                if( !cards2.isEmpty() ) {
                    cards2.remove(cards2.size()-1);
                }

                
            } else if( enumToInt(wCard1) < enumToInt(wCard2) ) {
                
                System.out.println("<<<<<<"+player2.getName()+" Won This Time>>>>>");
                cards2.add(0, wCard2);
                cards2.add(0, wCard1);
                count2++;
                if( !cards1.isEmpty() ) {
                    cards1.remove(cards1.size()-1);
                }
                if( !cards2.isEmpty() ) {
                    cards2.remove(cards2.size()-1);
                }

            } 
            
            
            System.out.println("--- Score: "+player1.getName()+"="+count1+" | "+player2.getName()+"="+count2+" ---");
            System.out.println("--- AllCards: "+player1.getName()+"="+cards1.size()+" | "+player2.getName()+"="+cards2.size()+" ---");
            
            
        }
        
        if( cards1.isEmpty() ) {
              player2.setGroupOfCards(group2);
           player2.setScore(count2);
             setWinner( player2);
             this.declareWinner();
        } else if ( cards2.isEmpty() ) {
             ( player1).setGroupOfCards(group1);
             ( player1).setScore(count1);
             setWinner( player1);
             this.declareWinner();
        }
        
    }
    
    @Override
    public void declareWinner() {
        System.out.println("***************************************");
        System.out.println("Winner: "+ this.Finalwinner.getName());
        System.out.println("Score: "+ this.Finalwinner.getScore());
        System.out.println("TotalCards: "+ this.Finalwinner.getGroupOfCards().getCards().size());
        System.out.println("Cards: "+ this.Finalwinner.getGroupOfCards().getCards());
    }
    
    private int enumToInt(WarCard warcard){
        
        int result;
        
        switch(warcard.getRank()){
            case ACE: result = 13;
                 break;  
            case KING: result = 12;
                 break; 
            case QUEEN: result = 11;
                 break; 
            case JACK: result = 10;
                 break;
            case TEN: result = 9;
                 break;
            case NINE: result = 8;
                 break;
            case EIGHT: result = 7;
                 break;
            case SEVEN: result = 6;
                 break;
            case SIX: result = 5;
                 break;
            case FIVE: result = 4;
                 break;
            case FOUR: result = 3;
                 break;
            case THREE: result = 2;
                 break;
            case TWO: result = 1;
                 break;
            default: result = 0;
                 break;   

        }
        
        return result;
    }

    
    private void playWarRound() {
        
        System.out.println("IT IS A WAR");
        
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WarGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( cards1.size() <= CardLimit || cards2.size() <= CardLimit ) {
            
            
            if( cards1.size() > cards2.size() ){
                
                count1++;
                
                System.out.println(player1.getName()+" has more cards ^_^");
                System.out.println("-------- "+player1.getName()+" gained all cards ---------");
                
                cards1.addAll(cards2);
                 player1.setGroupOfCards(group1);
                 player1.setScore(count1);
                setWinner( player1);
                cards2.clear();
                this.declareWinner();
                
            } else if( cards1.size() < cards2.size() ) {
                
                count2++;
                
                System.out.println(player2.getName()+" has more cards ~~~~>");
                System.out.println("---------"+player2.getName()+"  gained all cards ---------");
                
                cards2.addAll(cards1);
                ( player2).setGroupOfCards(group2);
                ( player2).setScore(count2);
                setWinner(player2);
                cards1.clear();
                this.declareWinner();
            }
        } else {
            
            begun1 = (cards1.size() - 1) ;
            final1 = begun1 -  CardLimit;
            
            begun2 = (cards2.size() - 1) ;
            final2 = begun2 -  CardLimit;
            
            for(int i = begun1; i > final1 ; i--){
                
                cd1 = cards1.get(i);
                wCard1 = ((WarCard) cd1);
                warRoundCards1.add(wCard1);
                
                if( !cards1.isEmpty() ) {
                    cards1.remove(cards1.size()-1);
                }
                
            }
            
            System.out.println(player1.getName()+" draws 3 cards down and one up: "+warRoundCards1.get(warRoundCards1.size()-1)  );
            
            for(int i = begun2; i > final2 ; i--){
                
                cd2 = cards2.get(i);
                wCard2 = ((WarCard) cd2);
                warRoundCards2.add(wCard2);
                
                if( !cards2.isEmpty() ) {
                    cards2.remove(cards2.size()-1);
                }
                
            }
            
            System.out.println(player2.getName()+" draws 3 down and one up "+warRoundCards2.get(warRoundCards2.size()-1)  );
            
            if( this.enumToInt(warRoundCards1.get(warRoundCards1.size()-1)) == this.enumToInt(warRoundCards2.get(warRoundCards2.size()-1)) ) {
                
                this.playWarRound();
                
            } else if ( this.enumToInt(warRoundCards1.get(warRoundCards1.size()-1)) > this.enumToInt(warRoundCards2.get(warRoundCards2.size()-1)) ) {
                
                count1++;
                System.out.println("--------- "+player1.getName()+" gained all cards -------");
                cards1.addAll( warRoundCards1 );
                cards1.addAll( warRoundCards2 );
                
                warRoundCards1.clear();
                warRoundCards2.clear();
                
            } else if ( this.enumToInt(warRoundCards1.get(warRoundCards1.size()-1)) < this.enumToInt(warRoundCards2.get(warRoundCards2.size()-1)) ) {
                
                count2++;
                System.out.println("------"+player2.getName()+" gained all the cards -----------");
                cards2.addAll( warRoundCards2 );
                cards2.addAll( warRoundCards1 );
                
                warRoundCards1.clear();
                warRoundCards2.clear();
                
            }
            
            
        }
    }
    
}
