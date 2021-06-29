public class hello
{
	public static void main(String[] arg)
	{
		System.out.println("Hello ADRAR !");
		int x = 5;
		float y = 2.5f;
		double z = 2.5552;
		double autre = 0;
		boolean moiMoi = true;
		char c5emeLettre = 'e';
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(autre);
		System.out.println(moiMoi);
		System.out.println(c5emeLettre);
		float result = x + y;
		System.out.println(result);
		x = x + (int)y;
		System.out.println(x);
		x = 3;
		int yy = --x + --x - ++x * 2;
		System.out.println(yy);
		String chaine = "blablabl";
		System.out.println(chaine);
		System.out.println(chaine+"e");
		System.out.println((int)(0.5 + Math.random()*10));
	}
}
