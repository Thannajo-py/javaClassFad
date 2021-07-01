public class MesMaths {
    public static String signe(double age){ return age == 0 ? "nul" : age < 0 ? "négatif" : "positif"; }
    public static int plusGrand2(int nb1, int nb2){ return nb1 > nb2 ? nb1 : nb2; }
    public static int plusPetit2(int nb1, int nb2){ return nb1 < nb2 ? nb1 : nb2; }
    public static int plusPetit3(int nb1, int nb2, int nb3){ return plusPetit2(plusPetit2(nb1,nb2),nb3); }
    public static int plusGrand3(int nb1, int nb2, int nb3){ return plusGrand2(plusGrand2(nb1,nb2),nb3); }
    public static void tableMultiplication(int chiffre, int debut, int fin){
        for (int i = debut; i <= fin; i++){
            System.out.println(chiffre + " X "+i+" = "+chiffre*i);
        }
    }
    public static void whileTableMultiplication(int chiffre, int debut, int fin){
        int i = debut;
        while (i <= fin) {
            System.out.println(chiffre + " X " + i + " = " + chiffre * i);
            i++;
        }
    }
    public static void doWhileTableMultiplication(int chiffre, int debut, int fin){
        int i = debut;
        do{
            System.out.println(chiffre + " X "+i+" = "+chiffre*i);
            i++;
        }while (i <= fin);
    }
    public static void boucleInfini(){
        for (;;);
    }
    public static void wboucleInfini(){
        while(true);
    }
    public static void dwboucleInfini(){
        do {}while(true);
    }
    public static boolean positifsOuPas(int n1, int n2, int n3){ return n1 > 0 && n2 > 0 && n3 > 0; }
}
