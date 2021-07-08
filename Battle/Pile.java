package Battle;

import java.util.ArrayList;

public class Pile {

    /**************
     * ATTRIBUTES *
     **************/

    private final ArrayList<Card> deck;

    /***************
     * CONSTRUCTOR *
     ***************/

    Pile(int nb){
        ArrayList<Card> pile = new ArrayList<>();
        CardsName[] cardInit = CardsName.values();
        CardsType[] colorInit = CardsType.values();
        for (int i = 0; i < cardInit.length ; i++){
            for(int j = 0; j < colorInit.length; j++) {
                Card instance = new Card(cardInit[i],colorInit[j]);
                pile.add(instance);
            }
        }
        ArrayList<Card> newDeck = new ArrayList<>(pile);
        this.deck = new ArrayList<>();
        for (int i = 0; i < nb; i++){
            int alea = (int) (Math.random()*newDeck.size());
            this.deck.add(newDeck.get(alea));
            if (newDeck.size() - 1 == 0){
                newDeck = new ArrayList<>(pile);
            }
            else {
                newDeck.remove(alea);
            }
        }
    }

    /**********
     * METHOD *
     **********/

    public ArrayList<Card> getPile(){
        return this.deck;
    }
}
