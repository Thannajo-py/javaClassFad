import java.util.Scanner;

public class morpionClass{
	public static char c1 = '1';
	public static char c2 = '2';
	public static char c3 = '3';
	public static char c4 = '4';
	public static char c5 = '5';
	public static char c6 = '6';
	public static char c7 = '7';
	public static char c8 = '8';
	public static char c9 = '9';
	public static boolean player1 = true;
	public static void main(String[] args){
		System.out.println("Bonjour");
		Scanner input = new Scanner(System.in);
		System.out.println("player1 choose your name:");
		String player1Name = input.nextLine();
		System.out.println("player2 choose your name:");
		String player2Name = input.nextLine();
		boolean end = false;
		int turn = 0;
		while (!end){
			aff();
			boolean hasplayed = false;
			if (player1){
				System.out.println(player1Name + " choisis une case:");
			}
			else{
				System.out.println(player2Name + " choisis une case:");
			}
			
			while (!hasplayed){
				String playerchoice = input.nextLine();
				hasplayed = play(playerchoice, player1);
				if (!hasplayed){
					if (player1){
						System.out.println("mauvais choix!" + player1Name + " Essayez encore:");
					}
					else{
						System.out.println("mauvais choix!" + player2Name + " Essayez encore:");
					}
					
				}
			}
			turn ++;
			end = finish(turn, player1, player1Name, player2Name);
			player1 = !player1;
			if (end){
				end = startAgain(input);	
			}
		}
	}
	public static void aff(){
		System.out.println( c1 + "|" + c2 + "|" + c3 + "\n" + c4 + "|" + c5 + "|" + c6 + "\n" +c7 + "|" + c8 + "|" + c9 +"\n");
	}
	public static boolean play(String playerchoice, boolean player1){
		switch(playerchoice){
			case "1":
				if (c1 != 'X' && c1 != 'O'){
					c1 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			case "2":
				if (c2 != 'X' && c2 != 'O'){
					c2 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			case "3":
				if (c3 != 'X' && c3 != 'O'){
					c3 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			case "4":
				if (c4 != 'X' && c4 != 'O'){
					c4 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			case "5":
				if (c5 != 'X' && c5 != 'O'){
					c5 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			case "6":
				if (c6 != 'X' && c6 != 'O'){
					c6 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			case "7":
				if (c7 != 'X' && c7 != 'O'){
					c7 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			case "8":
				if (c8 != 'X' && c8 != 'O'){
					c8 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			case "9":
				if (c9 != 'X' && c9 != 'O'){
					c9 = player1 == true ? 'X' : 'O';
					return true;
				}
				return false;
			default:
				return false;
		}
	}
	public static boolean finish(int turn, boolean player1, String player1Name, String player2Name){
		if ( (c1 == c2 && c2 == c3) || ( c4 == c5 && c5 == c6) || ( c7 == c8 && c8 == c9) || ( c1 == c4 && c4 == c7) || ( c2 == c5 && c5 == c8) || ( c3 == c6 && c6 == c9) || ( c2 == c5 && c5 == c8) || ( c3 == c5 && c5 == c7)){
			if(player1){
				System.out.println(player1Name + " victory");
				return true;
			}
			System.out.println(player2Name + " victory");
			return true;
		}
		if (turn == 9){
			aff();
			System.out.println("draw");
			return true;
		}
		return false;
	}
	public static boolean startAgain(Scanner input){
		while (true){
			System.out.println("voulez vous rejouer?(1 pour oui 2 pour non)");
			String replay = input.nextLine();
			switch (replay){
				case "1":
					c1 = '1';
					c2 = '2';
					c3 = '3';
					c4 = '4';
					c5 = '5';
					c6 = '6';
					c7 = '7';
					c8 = '8';
					c9 = '9';
					player1 = true;
					return false;
				case "2":
					return true;
				default:
					break;
			}
			System.out.println("wrong choice! Try again.");
		}
	}
}