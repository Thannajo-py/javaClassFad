package Battle;

class Player {

    /**************
     * ATTRIBUTES *
     **************/

    private String name;
    protected Deck deck;

    /***************
     * CONSTRUCTOR *
     ***************/

    public Player(String name, Pile deck, int nb){

        this.name = name;
        this.deck = new Deck(nb,deck);

    }

    public Player(){

    }
    protected void println(String a){
        System.out.println(a);
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

    public void won(Card wonCard){

        this.deck.earnACard(wonCard);

    }

    public void lose(){

        this.deck.loseACard();

    }



    public int deckSize(){

        return this.deck.deckLength();

    }

    public void print(){

        this.deck.print();

    }

    protected void setDeck(int nb, Pile deck) {

        this.deck = new Deck();
        this.deck.setDeck(nb, deck);

    }
    protected void setName(String nom){
        this.name = nom;
    }

    public Card getFirstElement(){

        return this.deck.getFirstElement();

    }

    public Card getElement(int nb){

        return this.deck.getElement(nb);

    }
    public String toString(){
        return this.name;
    }
}
