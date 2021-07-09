package Battle;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private int playedCard = 0;

    public HumanPlayer(Scanner input, Pile deck, int nb){
        new Player();
        println("Entrez nom joueur 1");
        String name = input.nextLine();
        setName(name);
        setDeck(nb, deck);
    }

    public Card play(){
        int nChoice;
        Scanner input = new Scanner(System.in);

        while (true) {

            println("Choisissez le numéro de carte à jouer (entre 0 et " + (this.deckSize() - 1) + ")");
            String choice = input.nextLine();

            while (!choice.matches("^[0-9]+$")) {

                println("Erreur! numéro invalide");
                choice = input.nextLine();

            }

            nChoice = Integer.parseInt(choice);

            if (nChoice < this.deckSize()) {

                break;

            }

            else {

                println("Erreur! numéro invalide");

            }

        }
        playedCard = nChoice;
        return this.getElement(nChoice);
    }
    public void lose(){

        this.deck.loseACard(playedCard);

    }


}
