package com.bridgelabz;

import java.util.ArrayList;

public class Player {
    ArrayList<String> cardList = new ArrayList<>();
    public Player(String firstname) {
        this.firstname = firstname;
    }

    String firstname;

    public void setCardList(String card){
        cardList.add(card);
    }
    public void getCard(){
        
        for(String position : cardList){
            System.out.print(position+", ");
        }
    }
}
