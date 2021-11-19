package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class DeckOfCards {
    static ArrayList<Player> players = new ArrayList<>();
    ArrayList<String> cards = new ArrayList<>();
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    String[] deck = new String[52];

    /*
     * uniqueDeckOfCard method is used to initialize the deck with cards
     */
    public void uniqueDeckOfCard() {
        int count = 0;
        for (int row = 0; row < suits.length; row++) {
            for (int column = 0; column < ranks.length; column++) {
                cards.add(suits[row] + ranks[column]);
            }
        }

    }

    /*
     * add multiple players
     * */
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


    public void shuffleCards() {
        for (int i = 0; i < cards.size(); i++) {
            int min = 0;
            int max = cards.size() - 1;
            int position = (int) (Math.random() * (max - min + 1) + min);
            int newPosition = (position - i);
            if (newPosition < 0 || newPosition > 52)
                newPosition = 0;
            String temp = cards.get(newPosition);
            cards.set(newPosition, cards.get(i));
            cards.set(i, temp);
        }
    }

    public String getCards() {
        int min = 0;
        int max = cards.size() - 1;
        int position = (int) (Math.random() * (max - min + 1) + min);
        System.out.print("\n Size : " + cards.size() + ", position : " + position);
        String returnValue = cards.get(position);
        cards.remove(position);
        return returnValue;
    }

    public void distributeCards() {
        for (int i = 1; i <= 9; i++) {
            for (Player playerObj : players) {
                playerObj.setCardList(getCards());
                shuffleCards();
            }
        }
    }

    public void setPlayerSequence() {
        Scanner sc = new Scanner(System.in);
        int playerSize = players.size();
        for (int i = 0; i < playerSize; i++) {
            Player temp = players.get(i);
            System.out.print("\n Set player position  " + temp.firstname + " : ");
            int newPosition = sc.nextInt();
            if (newPosition > playerSize || newPosition < 0) {
                System.out.print("Enter valid option");
                return;
            }
            players.set(i, players.get(newPosition));
            players.set(newPosition, temp);
        }
    }

    public void displayCard() {
        for (Player playerObj : players) {
            System.out.print("\ncards of " + playerObj.firstname + " : ");
            playerObj.getCard();
            System.out.print("\n ");
        }
    }

    public static void main(String[] args) {
        DeckOfCards cards = new DeckOfCards();
        cards.uniqueDeckOfCard();
        cards.addPlayers();
        cards.setPlayerSequence();
        cards.distributeCards();
        cards.displayCard();
    }
}