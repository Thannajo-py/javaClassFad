public class exo_2 {
    public static void main(String[] args){
        int[] age_test = {5,10,16,17,18,19,80};
        for (int a:age_test){
            quelPermis(a);
        }
        System.out.println(MesMaths.plusGrand2(2,3));
        MesMaths.tableMultiplication(5,1,15);
        MesMaths.whileTableMultiplication(5,1,15);
        MesMaths.doWhileTableMultiplication(5,1,15);
        System.out.println(ChaineDeCaractere.countMaj("AzerTyuIO"));
        assert(ChaineDeCaractere.countMaj("AzerTyuIO")==4);
        assert(ChaineDeCaractere.isValidPassword("AzerTyuIO0"));
        assert ChaineDeCaractere.isValidPassword("Azer"):"Not Valid";
        System.out.println(ChaineDeCaractere.NbDeA("AzerTyuIO0"));
        System.out.println(ChaineDeCaractere.plusHauteLettre("AzerTyuIO0"));
        System.out.println(ChaineDeCaractere.palindrome("AzerTyuIO0"));
        System.out.println(ChaineDeCaractere.palindrome("aaa"));
        System.out.println(ChaineDeCaractere.reverse("AzerTyuIO0"));
        System.out.println(ChaineDeCaractere.StringSansE("AzerTyuIO0"));
        System.out.println(ChaineDeCaractere.stringSansEspace("   AzerT  yuIO0   "));
        System.out.println(ChaineDeCaractere.stringSansEspaceAvantEtApres("   AzerT  yuIO0   "));
        System.out.println(ChaineDeCaractere.stringSansMajuscule("   AzerT  yuIO0   "));
        System.out.println(ChaineDeCaractere.StringSansVoyelle("   AzerT  yuIO0   "));
        assert(ChaineDeCaractere.palindrome("aaa")):true;
        System.out.println(ChaineDeCaractere.isValid("aaa"));
        System.out.println(ChaineDeCaractere.isValid("aaaaaaaaa"));
        System.out.println(ChaineDeCaractere.isValid(""));
        System.out.println(ChaineDeCaractere.isValid("A1a"));
        System.out.println(ChaineDeCaractere.isValid("A1anbvdfhe"));


    }
    public static boolean estMajeur(int age){ return age >=18; }
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
