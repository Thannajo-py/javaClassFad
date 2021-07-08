package Battle;

import java.util.Scanner;

class Play {

    public void battle(){
        Scanner input = new Scanner(System.in);
        boolean player = choosePlayer(input);
        int nb = initNbOfCards(input);
        Pile pile = new Pile(nb);
        Player p1 = initPlayer(input,"Saisissez nom joueur 1:",nb,pile);
        Player p2 = initPlayer(input, "Saisissez nom joueur 2:",nb,pile);
        Deck stack = new Deck(0,pile);
        long time = System.currentTimeMillis();
        int roundCount = 0;
        while (p1.deckSize() > 0 && p2.deckSize() > 0){
            round(p1, p2, stack, player, input);
            roundCount++;
        }
        endGame(p1, p2);
        println("durée de la partie " + (System.currentTimeMillis() - time) + " ms.\nnombre de manche: " + roundCount);
    }

    private boolean choosePlayer(Scanner input){
        println("tapez:\n1 pour jouer contre l'IA,\n2 pour que les IAs jouent entre elles.");
        String choice = input.nextLine();
        while (!choice.matches("^[1-2]$")){
            println("Erreur! Entrée invalide!");
            println("tapez:\n1 pour jouer contre l'IA,\n2 pour que les IAs jouent entre elles.");
            choice = input.nextLine();
        }
        return choice.equals("1");
    }

    private void endGame(Player p1, Player p2){
        if (p1.deckSize() == 0 && p2.deckSize() == 0){
            println("Egalité!");
        }
        else{
            println((p1.deckSize() == 0? p2.getName() : p1.getName()) + " gagne!" );
        }
    }

    private Player initPlayer(Scanner input, String message, int nb, Pile pile){
        println(message);
        return new Player(input.nextLine(), pile, nb);
    }

    private int initNbOfCards(Scanner input){
        println("saisissez le nombre de cartes(entre 0 et 9999):");
        String answer = input.nextLine();
        while (!answer.matches("^[0-9]{1,4}$")){
            println("erreur! Valeur incorrecte! Entrez un chiffre entre 0 et 9999");
            answer = input.nextLine();
        }
        return Integer.parseInt(answer);
    }

    private void round(Player p1, Player p2, Deck stack, boolean player, Scanner input){
        Card cJ1;
        int nChoice;
        if (!player) {
            cJ1 = p1.play();
            nChoice = p1.deckSize() - 1;
        }
        else {
            nChoice = humanTurn(input, p1);
            cJ1 = p1.getElement(nChoice);
        }
        Card cJ2 = p2.play();
        if (cJ1.compareTo(cJ2) > 0) {
            winARound(p1,p2,stack,cJ1,cJ2);
        }
        else if (cJ1.compareTo(cJ2) < 0){
            winARound(p2,p1,stack,cJ2,cJ1,nChoice);
        }
        else {
            p1.lose(nChoice);
            p2.lose();
            if (p1.deckSize() == 0 || p2.deckSize() == 0){
                println("Egalité! " + (p1.deckSize() == 0?p1.getName():p2.getName()) + " n'a plus assez de cartes pour continuer!");
                return;
            }
            toStack(cJ1, cJ2, p1, p2, stack);
        }
    }

    private void toStack(Card cJ1, Card cJ2, Player p1, Player p2, Deck stack){
        stack.earnACard(cJ1);
        stack.earnACard(cJ2);
        Card cJ1b = p1.play();
        Card cJ2b = p2.play();
        p1.lose();
        p2.lose();
        stack.earnACard(cJ1b);
        stack.earnACard(cJ2b);
        display(p1,p2,cJ1,cJ2);
    }

    private int humanTurn(Scanner input, Player p1){
        int nChoice;
        p1.print();
        while (true) {
            println("Choisissez le numéro de carte à jouer:");
            String choice = input.nextLine();
            while (!choice.matches("^[0-9]{1,4}$")) {
                println("Erreur! numéro invalide");
            }
            nChoice = Integer.parseInt(choice);
            if (nChoice < p1.deckSize()) {
                break;
            } else {
                println("Erreur! numéro invalide");
            }
        }
        return nChoice;
    }

    private void winARound(Player winner, Player loser, Deck stack, Card winCard, Card loseCard){
        winner.won(loseCard);
        loser.lose();
        while (stack.deckLength() > 0){
            Card current = stack.drawACard();
            winner.won(current);
            stack.loseACard();
        }
        display(winner, loser, winCard, loseCard);
    }

    private void winARound(Player winner, Player loser, Deck stack, Card winCard, Card loseCard, int nb){
        winner.won(loseCard);
        loser.lose(nb);
        while (stack.deckLength() > 0){
            Card current = stack.drawACard();
            winner.won(current);
            stack.loseACard();
        }
        display(winner, loser, winCard, loseCard);
    }

    private void println(String toPrint){
        System.out.println(toPrint);
    }

    private void display(Player winner, Player loser, Card winCard, Card loseCard){
        if (winCard.getValue().compareTo(loseCard.getValue()) == 0){
            println("Egalité! la carte " + winCard + " du joueur " + winner.getName() + " et la carte " +
                    loseCard + " du joueur " + loser.getName() + " et deux autres finissent dans le tas!" +
                    "\n" + winner.getName() + " a encore " + winner.deckSize() + " cartes et " + loser.getName() +
                    " a encore " + loser.deckSize() + " cartes.");
        }
        else{
            println((winner.getName() + " a battu la carte " + loseCard + " de " + loser.getName() +
                    " grâce à sa carte " + winCard + ".\n " + loser.getName() + " a encore " + loser.deckSize()
                    +  (loser.deckSize() > 1?" cartes " : " carte ") + "en main."));
        }
    }

}
