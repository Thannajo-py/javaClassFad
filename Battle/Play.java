package Battle;

import java.util.ArrayList;
import java.util.Scanner;

class Play {
    public void battle(){
        ArrayList<Card> pile = initPile();
        Scanner input = new Scanner(System.in);
        println("saisissez le nombre de cartes(entre 0 et 9999):");
        String answer = input.nextLine();
        while (!answer.matches("^[0-9]{1,4}$")){
            println("erreur! Valeur incorrecte! Entrez un chiffre entre 0 et 9999");
            answer = input.nextLine();
        }
        int nb = Integer.valueOf(answer);
        ArrayList<Card> randPile = randPile(nb,pile);
        println("saisissez nom joueur 1:");
        Player p1 = new Player(input.nextLine());
        p1.setDeck(nb,randPile);
        println("saisissez nom joueur 2:");
        Player p2 = new Player(input.nextLine(),randPile,nb);
        Player stack = new Player("stack",randPile,0);
        long time = System.currentTimeMillis();
        int roundCount = 0;
        while (p1.deckSize() > 0 && p2.deckSize() > 0){
            round(p1, p2, stack);
            roundCount++;
        }
        if (p1.deckSize() == 0 && p2.deckSize() == 0){
            println("Egalité!");
        }
        else{
            println((p1.deckSize() == 0? p2.getName() : p1.getName()) + " gagne!" );
        }
        println("durée de la partie " + (System.currentTimeMillis() - time) + " ms.\nnombre de manche: " + roundCount);
    }

    private ArrayList<Card> initPile(){
        ArrayList<Card> pile = new ArrayList<>();
        CardsName[] cardInit = CardsName.values();
        CardsType[] colorInit = CardsType.values();
        for (int i = 0; i < cardInit.length ; i++){
            for(int j = 0; j < colorInit.length; j++) {
                Card instance = new Card(cardInit[i],colorInit[j]);
                pile.add(instance);
            }
        }
        return pile;
    }

    private ArrayList<Card> randPile(int nb, ArrayList<Card> pile){
        ArrayList<Card> newDeck = new ArrayList<>(pile);
        ArrayList<Card> randPile = new ArrayList<>();
        for (int i = 0; i < nb; i++){
            int alea = (int) (Math.random()*newDeck.size());
            randPile.add(newDeck.get(alea));
            if (newDeck.size() - 1 == 0){
                newDeck = new ArrayList<>(pile);
            }
            else {
                newDeck.remove(alea);
            }
        }
        return randPile;
    }

    private void round(Player p1, Player p2, Player stack){
        Card cJ1 = p1.play();
        Card cJ2 = p2.play();
        if (cJ1.getValue().compareTo(cJ2.getValue()) > 0) {
            winARound(p1,p2,stack,cJ1,cJ2);
        }
        else if (cJ1.getValue().compareTo(cJ2.getValue()) < 0){
            winARound(p2,p1,stack,cJ2,cJ1);
        }
        else {
            p1.lose();
            p2.lose();
            if (p1.deckSize() == 0 || p2.deckSize() == 0){
                println("Egalité! " + (p1.deckSize() == 0?p1.getName():p2.getName()) + " n'a plus assez de cartes pour continuer!");
                return;
            }
            stack.won(cJ1);
            stack.won(cJ2);
            Card cJ1b = p1.play();
            Card cJ2b = p2.play();
            p1.lose();
            p2.lose();
            stack.won(cJ1b);
            stack.won(cJ2b);
            display(p1,p2,cJ1,cJ2);
        }
    }

    private void winARound(Player winner, Player loser, Player stack, Card winCard, Card loseCard){
        winner.won(loseCard);
        loser.lose();
        while (stack.deckSize() > 0){
            Card current = stack.play();
            winner.won(current);
            stack.lose();
        }
        display(winner, loser, winCard, loseCard);
    }

    private void println(String toPrint){
        System.out.println(toPrint);
    }

    private void display(Player winner, Player loser, Card winCard, Card loseCard){
        if (winCard.getValue().compareTo(loseCard.getValue()) == 0){
            println("Egalité! la carte " + winCard.getName() + " du joueur " + winner.getName() + " et la carte " +
                    loseCard.getName() + " du joueur " + loser.getName() + " et deux autres finissent dans le tas!" +
                    "\n" + winner.getName() + " a encore " + winner.deckSize() + " cartes et " + loser.getName() +
                    " a encore " + loser.deckSize() + " cartes.");
        }
        else{
            println((winner.getName() + " a battu la carte " + loseCard.getName() + " de " + loser.getName() +
                    " grâce à sa carte " + winCard.getName() + ".\n " + loser.getName() + " a encore " + loser.deckSize()
                    +  (loser.deckSize() > 1?" cartes " : " carte ") + "en main."));
        }
    }

}
