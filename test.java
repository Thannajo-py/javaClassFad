public class test {
    public static void main(String[] args){

        System.out.println(ChaineDeCaractere.countMaj("AzerTyuIO"));
        assert(ChaineDeCaractere.isValidPassword("AzerTyuIO0"));
        assert ChaineDeCaractere.isValidPassword("Azer");
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

    }
}
