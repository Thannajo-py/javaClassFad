package Battle;

import java.util.ArrayList;

class Deck {

    /**************
     * ATTRIBUTES *
     **************/

    private ArrayList<Card> list;

    /***************
     * CONSTRUCTOR *
     ***************/

    public Deck(){}

    /***********************************************************
     *                                                         *
     * @param nb : the number of cards desired                *
     * @param deck: the pile from which the card are extracted *
     ***********************************************************/

    public Deck(int nb, Pile deck){

        ArrayList<Card> newDeck = new ArrayList<>(deck.getPile());
        this.list = new ArrayList<>();

        for (int i = 0; i < nb; i++){

            int alea = (int) (Math.random()*newDeck.size());
            this.list.add(newDeck.get(alea));

            if (newDeck.size() - 1 == 0){
                newDeck = new ArrayList<>(deck.getPile());
            }

            else {
                newDeck.remove(alea);
            }

        }
    }

    /**********
     * METHOD *
     **********/

    public Card drawACard() {

        Card c = this.list.remove(0);
        this.list.add(c);
        return c;

    }

    /***********************************************************
     *                                                         *
     * @param nb : the number of cards desired                *
     * @param deck: the pile from which the card are extracted *
     ***********************************************************/

    public void setDeck(int nb, Pile deck) {

        ArrayList<Card> newDeck = new ArrayList<>(deck.getPile());
        this.list = new ArrayList<>();

        for (int i = 0; i < nb; i++) {

            int alea = (int) (Math.random() * newDeck.size());
            this.list.add(newDeck.get(alea));

            if (newDeck.size() - 1 == 0) {
                newDeck = new ArrayList<>(deck.getPile());
            }

            else {
                newDeck.remove(alea);
            }

        }
    }

    public void earnACard(Card wonCard) {

        this.list.add(wonCard);

    }

    public void loseACard() {

        this.list.remove(this.list.size() - 1);

    }

    public void loseACard(int nb) {

        this.list.remove(nb);
    }

    public int deckLength(){

        return this.list.size();

    }

    public void print(){
        int i = 0;

        for(Card c:this.list){
            System.out.println("Carte numéro " + i + ": " + c);
            i++;
        }

    }

    public Card getFirstElement(){

        return this.list.get(0);

    }

    public Card getElement(int nb){

        return this.list.get(nb);

    }

}