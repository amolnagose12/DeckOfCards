package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class DeckOfCards {
    static ArrayList<Player> players = new ArrayList<>();
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    String[] deck = new String[52];

    
    public void uniqueDeckOfCard() {
        int count = 0;
        for (int row = 0; row < suits.length; row++) {
            for (int column = 0; column < ranks.length; column++) {
                deck[count] = ranks[column] + "-" + suits[row] + " ";
                count++;
            }
        }

    }

    
    public void addPlayers() {
        int numberOfPlayers;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players");
        numberOfPlayers = sc.nextInt();
        if (numberOfPlayers < 2 || numberOfPlayers > 4) {
            System.out.println("Enter the value between 2 and 4");
            numberOfPlayers = sc.nextInt();
        }
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Enter the players name");
            Player player = new Player(sc.next());
            players.add(player);

        }
    }

    public static void main(String[] args) {
        DeckOfCards cards = new DeckOfCards();
        cards.uniqueDeckOfCard();
        cards.addPlayers();
    }
}