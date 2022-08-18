/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Hiba Alashraf
 */
public class CardGenerator {
    
    public static ArrayList<Card> generate() {

        ArrayList<Card> deck = new ArrayList<>();

        for( Suit s : Suit.values() ) {
            for( Rank r : Rank.values() ){

                Card WarCard = new WarCard(s, r);
                deck.add(WarCard);
            }
        }

        return deck;
    }
}
    

