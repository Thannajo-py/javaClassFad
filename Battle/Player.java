package Battle;

import java.util.ArrayList;

class Player {

    /**************
     * ATTRIBUTES *
     **************/

    private final String name;
    private Deck deck;

    /***************
     * CONSTRUCTOR *
     ***************/

    public Player(String name, ArrayList<Card> deck, int nb){
        this.name = name;
        this.deck = new Deck(nb,deck);
    }
    public Player(String name){
        this.name = name;
    }

    /**********
     * METHOD *
     **********/
    public Card play(){
        return drawACard();
    }
    private Card drawACard() {
        return this.deck.drawACard();
    }
    public String getName(){
        return this.name;
    }

    public void won(Card wonCard){
        this.deck.earnACard(wonCard);
    }
    public void lose(){
        this.deck.loseACard();
    }
    public int deckSize(){
        return this.deck.deckLength();
    }
    public void setDeck(int nb, ArrayList<Card> deck) {
        this.deck = new Deck();
        this.deck.setDeck(nb, deck);
    }
}
