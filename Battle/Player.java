package Battle;

class Player {

    /**************
     * ATTRIBUTES *
     **************/

    private final String name;
    private Deck deck;

    /***************
     * CONSTRUCTOR *
     ***************/

    public Player(String name, Pile deck, int nb){
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

    public void lose(int nb){
        this.deck.loseACard(nb);
    }

    public int deckSize(){
        return this.deck.deckLength();
    }

    public void print(){
        this.deck.print();
    }

    public void setDeck(int nb, Pile deck) {
        this.deck = new Deck();
        this.deck.setDeck(nb, deck);
    }

    public Card getFirstElement(){
        return this.deck.getFirstElement();
    }

    public Card getElement(int nb){
        return this.deck.getElement(nb);
    }
}
