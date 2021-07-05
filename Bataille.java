import java.util.Scanner;


public class Bataille {
    public static Cards[] p1 = initCartes();
    public static Cards[] p2 = initCartes();
    public static String p1Name = "";
    public static String p2Name = "";


    public static void main(String[] args){
        jeu();
    }


    public static Cards[] initCartes(){
        return ArrayUtils.fusion(ArrayUtils.fusion(ArrayUtils.fusion(Cards.values(),Cards.values()),Cards.values()),Cards.values());
    }


    public static Cards tirerUneCarte(Cards[] deck){
        return deck[(int)(Math.random()*deck.length)];
    }


    public static short quiGagneLeTour(Cards c1, Cards c2){
        return (short)c1.compareTo(c2);
    }


    public static void transfererCarte(Cards p1Cards, Cards p2Cards) {
        int p1Loc = findACard(p1, p1Cards);
        int p2Loc = findACard(p2, p2Cards);
        if (quiGagneLeTour(p1Cards, p2Cards) < 0){
            p2 = ArrayUtils.add(p2, p1Cards);
            p1 = ArrayUtils.remove(p1,p1Loc);
            afficherTour(p2Name, p1Name, p2Cards, p1Cards, p1.length);
        }
        else if (quiGagneLeTour(p1Cards, p2Cards) > 0){
            p1 = ArrayUtils.add(p1, p2Cards);
            p2 = ArrayUtils.remove(p2,p2Loc);
            afficherTour(p1Name, p2Name, p1Cards, p2Cards, p2.length);
        }
        else{
            p2 = ArrayUtils.remove(p2,p2Loc);
            p1 = ArrayUtils.remove(p1,p1Loc);
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
        long temps = System.currentTimeMillis();
        while (p2.length > 0 && p1.length > 0){
            transfererCarte(tirerUneCarte(p1), tirerUneCarte(p2));
        }
        if (p1.length == 0 && p2.length == 0){
            System.out.println("Egalité!");
        }
        else{
            System.out.println((p1.length == 0? p2Name : p1Name) + " gagne!" );
        }
        System.out.println("Total duration: " + (double)(System.currentTimeMillis() - temps) / 1000 + " s.");
    }

    public static int findACard(Cards[] deck, Cards cards) {
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
