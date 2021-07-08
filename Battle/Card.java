package Battle;

class Card {

    /**************
     * ATTRIBUTES *
     **************/

    private final CardsName name;
    private final CardsType type;

    /***************
     * CONSTRUCTOR *
     ***************/

    public Card(CardsName name, CardsType typeOfCard){
        this.name = name;
        this.type = typeOfCard;
    }

    /**********
     * METHOD *
     **********/

    public CardsName getValue(){
        return this.name;
    }

    public int compareTo(Card other){
        return this.name.compareTo(other.name);
    }

    public String toString(){
        return (name + " de " + type);
    }
}


enum CardsType {
    PIQUE,
    TREFLE,
    CARREAU,
    COEUR
}


enum CardsName {
    AS,
    DEUX,
    TROIS,
    QUATRE,
    CINQ,
    SIX,
    SEPT,
    HUIT,
    NEUF,
    DIX,
    VALET,
    DAME,
    ROI
}