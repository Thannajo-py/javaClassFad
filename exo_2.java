public class exo_2 {
    public static void main(String[] args){
        int[] age_test = {5,10,16,17,18,19,80};
        for (int a:age_test){
            quelPermis(a);
        }
    }
    public static boolean estMajeur(int age){ return age >=18; }
    public static String signe(double age){ return age == 0 ? "nul" : age < 0 ? "négatif" : "positif"; }
    public static int plusGrand2(int nb1, int nb2){ return nb1 > nb2 ? nb1 : nb2; }
    public static int plusPetit2(int nb1, int nb2){ return nb1 < nb2 ? nb1 : nb2; }
    public static int plusPetit3(int nb1, int nb2, int nb3){ return plusPetit2(plusPetit2(nb1,nb2),nb3); }
    public static int plusGrand3(int nb1, int nb2, int nb3){ return plusGrand2(plusGrand2(nb1,nb2),nb3); }
    public static boolean positifsOuPas(int n1, int n2, int n3){ return n1 > 0 && n2 > 0 && n3 > 0; }
    public static void quelPermis(int age){System.out.println(age < 16 ? "Passager d'un véhicule" : age < 18 ? "Eligible conduite accompagnée" : "Elligible Permis B");}
    public static String capitale(String pays){
        return switch (pays) {
            case "France" -> "Paris";
            case "Allemagne" -> "Berlin";
            case "Italie" -> "Rome";
            case "Maroc" -> "Rabat";
            case "Espagne" -> "Madrid";
            case "Portugal" -> "Lisbonne";
            case "Angleterre" -> "Londres";
            default -> "Inconnu";
        };
    }

}
