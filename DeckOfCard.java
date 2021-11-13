package com.bridgelabz;

public class DeckOfCard {

	
	public static void uniqueCards() {
		
		String[] deck = new String[52];
	    String[] suits = { "Diamonds", "Clubs","Spades", "Hearts",};
	    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Ace"};
	    
	    int count = 0;
        for (int row = 0; row < suits.length; row++) {
            for (int column = 0; column < ranks.length; column++) {
                deck[count] = ranks[column] + "-" + suits[row] + " ";
                count++;
            }
           }
        }
        public static void main(String[] args) {
            DeckOfCard cards = new DeckOfCard();
            cards.uniqueCards();
        }
    }