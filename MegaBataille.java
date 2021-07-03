import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MegaBataille {
    public static Cards[] deckP1;
    public static int deckP1Length;
    public static String p1Name;
    public static Cards[] deckP2;
    public static int deckP2Length;
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


    public static short quiGagneLeTour(Cards c1, Cards c2){
        return (short)c1.compareTo(c2);
    }


    public static void transfererCarte(int p1Loc, int p2Loc) {
        Cards p2Cards = deckP2[p2Loc];
        Cards p1Cards = deckP1[p1Loc];
        if (quiGagneLeTour(deckP1[p1Loc], deckP2[p2Loc]) < 0){
            deckP2[deckP2Length] = deckP1[p1Loc];
            deckP1[p1Loc] = deckP1[deckP1Length - 1];
            deckP2Length++;
            deckP1Length--;
            afficherTour(p2Name, p1Name, p2Cards, p1Cards, deckP1Length);
        }
        else if (quiGagneLeTour(p1Cards, p2Cards) > 0){
            deckP1[deckP1Length] = deckP2[p2Loc];
            deckP2[p2Loc] = deckP2[deckP2Length - 1];
            deckP2Length--;
            deckP1Length++;
            afficherTour(p2Name, p1Name, p2Cards, p1Cards, deckP2Length);
        }
        else{
            deckP2[p2Loc] = deckP2[deckP2Length - 1];
            deckP2Length--;
            deckP1[p1Loc] = deckP1[deckP1Length - 1];
            deckP1Length--;
            afficherTour(p1Name, p2Name, p1Cards, p2Cards, -1);

        }
    }


    public static void afficherTour(String winner, String looser, Cards winnerCards, Cards looserCards, int remaining) {
        if (remaining != -1){
            System.out.println(winner + " a battu la carte " + looserCards + " de " + looser + " grâce à sa carte " +
                    winnerCards + ".\n " + looser + " a encore " + remaining +
                    (remaining > 1?" cartes " : "carte ") + "en main.");}
        else{
            System.out.println("Egalité! "+ p1Name + " et " + p2Name + " perdent leur carte " + winnerCards + ".");
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
            System.out.println("Veuillez entrer un nombre:\nNombre de cartes par Deck?");
            nbCardsInput = input.nextLine();
        }
        long temps = System.currentTimeMillis();
        int nbCards = parseInt(nbCardsInput);
        deckP1 = initCartes(nbCards);
        deckP1Length = nbCards;
        deckP2 = initCartes(nbCards);
        deckP2Length = nbCards;

        while (deckP1Length > 0 && deckP2Length > 0){
            transfererCarte(tirerUneCarte(deckP1Length), tirerUneCarte(deckP2Length));
        }
        System.out.println((deckP1Length == 0? p2Name : p1Name) + " gagne!" );
        System.out.println("Total duration: " + (double)(System.currentTimeMillis() - temps) / 1000 + " s.");
    }

    public static int findACard(Bataille.Cards[] deck, Bataille.Cards cards) {
        for (int i = 0; i < deck.length; i++){
            if (deck[i].compareTo(cards) == 0){
                return i;
            }
        }
        return -1;
    }

    public enum Cards {
        as, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, valet, dame, roi
    }
}
