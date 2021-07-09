package com.adrar;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MegaBataille {

    public static Cards[] deckP1;
    public static int deckP1Length;
    public static String p1Name;
    public static Cards[] deckP2;
    public static int deckP2Length;
    public static Cards[] battleStack;
    public static int battleLength;
    public static String p2Name;


    public static void main(String[] args){
        jeu();
    }


    public static Cards[] initCartes(int nb){

        Cards[] deck = new Cards[2 * nb];
        Cards[] stack = Cards.values();

        for (int count = 0; count < nb; count++){

                deck[count] = stack[count % stack.length];

        }

        return deck;

    }


    public static int tirerUneCarte(int deckLength){

        return (int)(Math.random()*deckLength);
    }


    public static short quiGagneLeTour(Cards c1, Cards c2) {

        return (short)c1.compareTo(c2);

    }


    public static int perdreUneCarte(int deckLength, int loc, Cards[] deck){

        deck[loc] = deck[deckLength-1];
        return --deckLength;

    }


    public static int gagnerUneCarte(int deckLength, int loc, Cards[] winDeck, Cards[] loseDeck){
        winDeck[deckLength] = loseDeck[loc];
        return ++deckLength;
    }


    public static int gagnerLeTas(int deckLength, Cards[] deck){
        for (int i = 0; i < battleLength;i++){
            deck[deckLength + i] = battleStack[i];
        }
        deckLength += battleLength;
        battleLength = 0;
        return deckLength;
    }


    public static void bataille(int p1Loc, int p2Loc){
        if(deckP1Length < 2 || deckP2Length < 2){
            deckP1Length -= 2;
            deckP2Length -= 2;
        }
        else{
            battleLength = gagnerUneCarte(battleLength, p2Loc, battleStack,deckP2);
            battleLength = gagnerUneCarte(battleLength, p1Loc, battleStack,deckP1);
            deckP1Length = perdreUneCarte(deckP1Length, p1Loc, deckP1);
            deckP2Length = perdreUneCarte(deckP2Length, p2Loc, deckP2);
            int b2Loc = tirerUneCarte(deckP2Length);
            battleLength = gagnerUneCarte(battleLength, b2Loc, battleStack,deckP2);
            deckP2Length = perdreUneCarte(deckP2Length, b2Loc, deckP2);
            int b1Loc = tirerUneCarte(deckP1Length);
            battleLength = gagnerUneCarte(battleLength, b1Loc, battleStack,deckP1);
            deckP1Length = perdreUneCarte(deckP1Length, b1Loc, deckP1);
        }
    }


    public static void transfererCarte(int p1Loc, int p2Loc) {
        Cards p2Cards = deckP2[p2Loc];
        Cards p1Cards = deckP1[p1Loc];
        if (quiGagneLeTour(deckP1[p1Loc], deckP2[p2Loc]) < 0){
            deckP2Length = gagnerUneCarte(deckP2Length, p1Loc, deckP2, deckP1);
            deckP1Length = perdreUneCarte(deckP1Length, p1Loc, deckP1);
            if (battleLength > 0){
                deckP2Length = gagnerLeTas(deckP2Length, deckP2);
            }
            afficherTour(p2Name, p1Name, p2Cards, p1Cards, deckP1Length);
        }
        else if (quiGagneLeTour(p1Cards, p2Cards) > 0){
            deckP1Length = gagnerUneCarte(deckP1Length, p2Loc, deckP1, deckP2);
            deckP2Length = perdreUneCarte(deckP2Length, p2Loc, deckP2);
            if (battleLength > 0){
                deckP1Length = gagnerLeTas(deckP1Length, deckP1);
            }
            afficherTour(p1Name, p2Name, p1Cards, p2Cards, deckP2Length);
        }
        else{
            bataille(p1Loc, p2Loc);
            afficherTour(p1Name, p2Name, p1Cards, p2Cards, -1);

        }
    }


    public static void afficherTour(String winner, String looser, Cards winnerCards, Cards looserCards, int remaining) {
        if (remaining != -1){
            System.out.println(winner + " a battu la carte " + looserCards + " de " + looser + " grâce à sa carte " +
                    winnerCards + ".\n " + looser + " a encore " + remaining +
                    (remaining > 1?" cartes " : "carte ") + "en main.");}
        else{
            System.out.println("com.adrar.Bataille! "+ p1Name + " et " + p2Name + " mettent leur carte " + winnerCards + " ainsi qu'une autre dans le stack.");
        }
    }


    public static void jeu (){
        Scanner input = new Scanner(System.in);
        System.out.println("Joueur 1 entrez votre nom:");
        p1Name = input.nextLine();
        System.out.println("Joueur 2 entrez votre nom:");
        p2Name = input.nextLine();
        System.out.println("Nombre de cartes par Deck?");
        String nbCardsInput = input.nextLine();
        while(!nbCardsInput.matches("^[0-9]{1,8}$")){
            System.out.println("Veuillez entrer un nombre positif:\nNombre de cartes par Deck?");
            nbCardsInput = input.nextLine();
        }
        int nbCards = parseInt(nbCardsInput);
        deckP1 = initCartes(nbCards);
        deckP1Length = nbCards;
        deckP2 = initCartes(nbCards);
        deckP2Length = nbCards;
        battleStack = initCartes(nbCards);
        battleLength = 0;
        long temps = System.currentTimeMillis();
        int round = 0;
        while (deckP1Length > 0 && deckP2Length > 0){
            transfererCarte(tirerUneCarte(deckP1Length), tirerUneCarte(deckP2Length));
            round++;
        }
        if (deckP1Length <= 0 && deckP2Length <= 0){
            System.out.println("Egalité!");
        }
        else{
            System.out.println((deckP1Length == 0? p2Name : p1Name) + " gagne!" );
        }
        System.out.println("Total duration: " + (double)(System.currentTimeMillis() - temps) / 1000 + " s." +
                "\nNombre de manche total: "+round);
    }


    public enum Cards {
        as, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, valet, dame, roi
    }
}
