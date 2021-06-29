public class low1
{
	public static String helloWorld()
	{
		return "Hello ADRAR World!";
	}
	
	
	public static String quiEstLeMeilleurProf()
	{
		return "le prof de programmation java!";
	}
	
	
	public static String jeRetourneMonArgument(String argument)
	{
		return argument;
	}
	
	
	public static String concatenation(String argument1, String argument2)
	{
		return argument1 + argument2;
	}
	
	
	public static String concatenationAvecEspace(String argument1, String argument2)
	{
		return argument1 + " " + argument2;
	}
	
	
	public static void afficher(String argument)
	{
		System.out.println(argument);
	}
	
	
	public static int somme(int arg1, int arg2)
	{
		return arg1 + arg2;
	}
	
	
	public static int soustraction(int arg1, int arg2)
	{
		return arg1 - arg2;
	}
	
	
	public static int multiplication(int arg1, int arg2)
	{
		return arg1 * arg2;
	}
	
	
	public static String calculTTC(float arg1)
	{ 	
		float TVA = 1.055f;
		float prixTTC = arg1 * TVA;
		return String.format("%.2f",prixTTC);
	}
	
	
	public static void afficherPlatDuJour(String entree, float entreePrix, String plat, float platPrix, String dessert, float dessertPrix)
	{ 
		System.out.println("Le chef vous propose aujourd'hui\n\t-Entrée: "+entree+" ("+calculTTC(entreePrix)+"€)\n\t-Plat: "+plat+" ("+calculTTC(platPrix)+"€)\n\t-Dessert: "+dessert+" ("+calculTTC(dessertPrix)+"€)\nNous remercions notre aimable clientele par avance de vouloir regler en bitcoin.");
	}
	
	
	public static String mentionBachelier(float arg1)
	{ 	
		if (arg1 < 0.5f)
		{
			return "<50%:\"pas reussi\"";
		}
		else if (arg1 < 0.6f)
		{
			return "<60%:\"reussi\"";
		}
		else if (arg1 < 0.7f)
		{
			return "<70%:\"satisfaction\"";
		}
		else if (arg1 < 0.8f)
		{
			return "<80%:\"distinction\"";
		}
		else if (arg1 < 0.9f)
		{
			return "<60%:\"une grande distinction\"";
		}
		else
		{
			return "<=100%:\"la plus grande distinction\"";
		}
	}
	
	
	public static void main(String[] arg)
	{
		System.out.println(helloWorld());
		afficher("123");
		afficherPlatDuJour("oeuf",1.25f,"steack",15.00f,"flamby",0.50f);
		System.out.println(quiEstLeMeilleurProf());
		System.out.println(jeRetourneMonArgument("1234"));
		System.out.println(helloWorld());
		System.out.println(concatenation("123","456"));
		System.out.println(concatenationAvecEspace("123","456"));
		System.out.println(somme(1,1));
		System.out.println(soustraction(1,1));
		System.out.println(multiplication(2,2));
		System.out.println(calculTTC(10));
		System.out.println(mentionBachelier(0.7f));
	}
}
