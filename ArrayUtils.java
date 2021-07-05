public class ArrayUtils {
    /**Remplis le tableau de valeurs aléatoires comprises entre 0 et99 */
    public static void fillTab(int[] tab) {
        for (int i=0; i < tab.length; i++) {
            tab[i] = (int)((Math.random()*99)+0.5);
        }
    }
    /** Affiche le tableau dans la console sur 1 seule ligne */
    public static void printTab(int[] tab) {
        String solution = "[" + tab[0];
        for (int i = 1; i < tab.length; i++) {
            solution += ", " + tab[i];
        }
        System.out.println(solution + "]");
    }
    public static void printTab(Bataille.Cards[] tab) {
        String solution = "[" + tab[0];
        for (int i = 1; i < tab.length; i++) {
            solution += ", " + tab[i];
        }
        System.out.println(solution + "]");
    }
    /** Retourne la valeur maximum du tableau */
    public static int getMax(int[] tab) {
        int max = tab[0];
        for(int i = 1; i < tab.length; i++) {
            if (tab[i] > max){
                max = tab[i];
            }
        }
        return max;
    }
    /** Permute l’emplacement i et j dans le tableau */
    public static void permute(int[] tab, int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
    //Retourne la somme des cases d'un tableau
    public static int getSum(int[] tab) {
        int sum = 0;
        for(int i = 0; i < tab.length; i++) {
            sum += tab[i];
        }
        return sum;
    }
    //Retourne la moyenne des cases d'un tableau
    public static int getAverage(int[] tab) {
        return (getSum(tab)/tab.length);
    }
    //Affiche les valeurs supérieurs à la moyenne (ne retourne rien) d'un tableau
    public static void showBetterThanAverage(int[] tab) {
        int avg = getAverage(tab);
        for(int i = 0; i < tab.length; i++) {
            if(tab[i] > avg){
                System.out.println(tab[i]);
            }
        }
    }
    //Retourne le nombre d’occurrence de la valeur maximum (Version O(2n) et O(n))
    public static int maxOccurence(int[] tab) {
        int max = getMax(tab);
        int occurence = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] == max) {
                occurence++;
            }
        }
        return occurence;
    }
    /** Crée et retourne un nouveau tableau qui est la concaténation des 2 tableaux **/
    public static int[] fusion(int[]tab1, int[] tab2) {
        int[] tab3 = new int[tab1.length+tab2.length];
        for (int i = 0; i < tab1.length; i++){
            tab3[i] = tab1[i];
        }

        for (int i = 0; i < tab2.length; i++) {
            tab3[tab1.length + i] = tab2[i];
        }
        return tab3;
    }
    public static Bataille.Cards[] fusion(Bataille.Cards[]tab1, Bataille.Cards[] tab2) {
        Bataille.Cards[] tab3 = new Bataille.Cards[tab1.length+tab2.length];
        for (int i = 0; i < tab1.length; i++){
            tab3[i] = tab1[i];
        }

        for (int i = 0; i < tab2.length; i++) {
            tab3[tab1.length + i] = tab2[i];
        }
        return tab3;
    }
    /** Retourne un tableau avec une nouvelle valeur ajoutée **/
    public static int[] add(int[] pTab, int pValeurNouvelle) {
        int[] tab = {pValeurNouvelle};
        return fusion(pTab, tab);
    }
    public static Bataille.Cards[] add(Bataille.Cards[] pTab, Bataille.Cards pValeurNouvelle) {
        Bataille.Cards[] tab = {pValeurNouvelle};
        return fusion(pTab, tab);
    }
    /** Supprime un élément du tableau **/
    public static int[] remove(int[] pTab, int pIndiceASupprimer) {
        int[] tab = new int[pIndiceASupprimer];
        int pTabi = 0;
        int tabi = 0;
        while (tabi < tab.length) {
            if (pTabi == pIndiceASupprimer){
                pTabi++;
                continue;
            }
            tab[tabi] = pTab[pTabi];
            tabi++;
            pTabi++;
        }
        return tab;
    }
    public static Bataille.Cards[] remove(Bataille.Cards[] pTab, int pIndiceASupprimer) {
        Bataille.Cards[] tab = new Bataille.Cards[pTab.length - 1];
        int pTabi = 0;
        int tabi = 0;
        while (tabi < tab.length) {
            if (pTabi == pIndiceASupprimer){
                pTabi++;
                continue;
            }
            tab[tabi] = pTab[pTabi];
            tabi++;
            pTabi++;
        }
        return tab;
    }

}
