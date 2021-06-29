import java.util.Scanner;

public class vieux{
	
	public static void main(String[] arg) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Quel est ton âge ?");
	int age = scanner.nextInt();
	scanner.nextLine();
	String texteAAfficher;
	
		if (age < 21){
			System.out.println("tu es jeune");
		}
		else {
		System.out.println("tu es vieux");
		}
	scanner.close();
	}
	
}