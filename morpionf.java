import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class morpionf
{/*Author: thannajo
	date 07 may 2021
	version : 2.0
	purpose: a noughts and crosses game for 2 players
	IN: a series of instruction of 2 digits representing the row and col represented by a string of the current player
	OUT: print on screen Instruction for the player, the grid of the game, the winner if any or tie.*/
	
	
	public static boolean winCheck(String[][] table, boolean player1, boolean multiplayer, String player1Name, String player2Name)
	{/*check the grid for a winner
		check if a row, a line or one of the two diagonals have 3 of a type
		entry: the game table
		out: if someone has won.*/
		String check = "X";
		if (player1) 
		{
			check = "O";
		}
		for (int line = 0; line < 3; line++)
		{
			int winningLine = 0;
			int winningCol = 0;
			int winningDiagonal = 0;
			int winningRDiagonal = 0;
			for (int col = 0; col < 3; col++)
			{
				if (table[line][col].equals(check))
				{
					winningLine ++;
				}
				if (table[col][line].equals(check))
				{
					winningCol ++;
				}
				if (table[col][col].equals(check))
				{
					winningDiagonal ++;
				}
				if (table[col][2-col].equals(check))
				{
					winningRDiagonal ++;
				}
			}
			if (winningLine == 3 || winningCol == 3 || winningDiagonal == 3 || winningRDiagonal == 3)
			{
				if (player1)
				{
					System.out.println(player2Name+" win!");
					return true;
				}
				else
				{
					System.out.println(player1Name+" win!");
					return true;
				}
			}
		
		}
		return false;
	}
	
	
	public static void iaPlay(String [][] table, int turn)
	{/* make the IA play following the following pattern: play the winning possibility if any, else avoid the winning possibility of the player else play something else
		IN:turn number, the grid
		OUT: modify the grid accordingly*/
		if (turn < 3)
		{
			if (table[1][1].equals(" "))
			{
				table[1][1] = "O";
			}
			else
			{
				table[0][0] = "O";
			}
		}
		else 
		{
			boolean hasPlayed = false;
			hasPlayed = requiredPlay(table, "O"); //IA play if it can win!
			if (!hasPlayed)
			{
				hasPlayed = requiredPlay(table, "X");//IA play for not loosing
			}
			if (!hasPlayed)
			{
				hasPlayed = selectBestChoice(table);
			}
			if (!hasPlayed)
			{
				fillingPlay(table);//no winning possibility IA just fill a case
			}
		}
	}
	
	
	public static boolean requiredPlay(String[][] table, String toCheck)
	{/* make the IA play the winning possibility if any, else avoid the winning possibility of the player.
		IN:the string to check(either the IA sign to win or the player sign not to lose), the grid
		OUT: if one of the case is reached play and return true else return false*/
		boolean hasPlayed = false;
		for (int line = 0; line < 3; line++)
		{
			int lineOCount = 0;
			int lineEmptyCount = 0;
			int lineEmptyCoordinaterow = -1;
			int lineEmptyCoordinatecol = -1;
			int colOCount = 0;
			int colEmptyCount = 0;
			int colEmptyCoordinaterow = -1;
			int colEmptyCoordinatecol = -1;
			int diagonalOcount = 0;
			int diagonalEmptyCount = 0;
			int diagonalEmptyCoordinate = -1;
			int rDiagonalOcount = 0;
			int rDiagonalEmptyCount = 0;
			int rDiagonalEmptyCoordinate = -1;
			for (int data = 0; data < 3; data++)
			{
				if (table[line][data].equals(toCheck))//checking line
				{
					lineOCount++;
				}
				else if (table[line][data].equals(" "))
				{
					lineEmptyCount++;
					lineEmptyCoordinaterow = line;
					lineEmptyCoordinatecol = data;
				}
				if (table[data][line].equals(toCheck))//checking col
				{
					colOCount++;
				}
				else if (table[data][line].equals(" "))
				{
					colEmptyCount++;
					colEmptyCoordinatecol = line;
					colEmptyCoordinaterow = data;
				}
				if (table[data][data].equals(toCheck))//checking diagonal
				{
					diagonalOcount++;
				}
				else if (table[data][data].equals(" "))
				{
					diagonalEmptyCount++;
					diagonalEmptyCoordinate = data;
				}
				if (table[data][2-data].equals(toCheck))//checking reverse diagonal
				{
					rDiagonalOcount++;
				}
				else if (table[data][2-data].equals(" "))
				{
					rDiagonalEmptyCount++;
					rDiagonalEmptyCoordinate = data;
				}
			}
			if (lineOCount == 2 && lineEmptyCount == 1 )
			{
				table[lineEmptyCoordinaterow][lineEmptyCoordinatecol] = "O";
				hasPlayed = true;
			}
			else if (colOCount == 2 && colEmptyCount == 1 )
			{
				table[colEmptyCoordinaterow][colEmptyCoordinatecol] = "O";
				hasPlayed = true;
			}
			else if (diagonalOcount == 2 && diagonalEmptyCount == 1 )
			{
				table[diagonalEmptyCoordinate][diagonalEmptyCoordinate] = "O";
				hasPlayed = true;
			}
			else if (rDiagonalOcount == 2 && rDiagonalEmptyCount == 1 )
			{
				table[rDiagonalEmptyCoordinate][2-rDiagonalEmptyCoordinate] = "O";
				hasPlayed = true;
			}
			if (hasPlayed)
			{
				break;
			}
		}
		return hasPlayed;
	}
	
	
	public static void fillingPlay(String[][] table)
	{/* make the IA play the first empty case
		IN:the grid
		OUT: cross the first empty case, no return*/
		boolean hasPlayed = false;
		for (int line = 0; line < 3; line ++)
		{
			for (int data = 0; data < 3; data ++)
			{
				if (table[line][data].equals(" "))
				{
					table[line][data] = "O";
					hasPlayed = true;
					break;
				}
			}
			if (hasPlayed)
			{
				break;
			}
		}
	}
	
	
	public static boolean selectBestChoice(String[][] table)
	{/* in case of non winning or non losing turn check the best answer if any
		IN:the grid
		OUT: cross the first best case, return true if played, false else*/
		boolean hasPlayed = false;
		HashMap<Integer,Integer> pointPossibility = new HashMap<Integer, Integer>();
		pointPossibility.put(0,0);
		pointPossibility.put(1,0);
		pointPossibility.put(2,0);
		pointPossibility.put(10,0);
		pointPossibility.put(11,0);
		pointPossibility.put(12,0);
		pointPossibility.put(20,0);
		pointPossibility.put(21,0);
		pointPossibility.put(22,0);
		
		for (int line = 0; line <3; line++)
		{
			ArrayList<Integer> lineEmptyCase = new ArrayList<Integer>();
			ArrayList<Integer> colEmptyCase = new ArrayList<Integer>();
			ArrayList<Integer> diagonalEmptyCase = new ArrayList<Integer>();
			ArrayList<Integer> rDiagonalEmptyCase = new ArrayList<Integer>();
			boolean lineWithoutX = true;
			boolean colWithoutX = true;
			boolean diagonalWithoutX = true;
			boolean rDiagonalWithoutX = true;
			for (int data = 0; data < 3; data++)
			{
				if (line == 0)
				{
					if (table[data][data].equals("X"))
					{
						diagonalWithoutX = false;
					}
					else if (diagonalWithoutX && table[data][data].equals(" "))
					{
						diagonalEmptyCase.add(data * 11);
					}
					if (table[data][2-data].equals("X"))
					{
						rDiagonalWithoutX = false;
					}
					else if (rDiagonalWithoutX && table[data][2-data].equals(" "))
					{
						rDiagonalEmptyCase.add(data * 10 + (2-data));
					}
				}
				if (table[line][data].equals("X"))
				{
					lineWithoutX = false;
				}
				else if (lineWithoutX && table[line][data].equals(" "))
				{
					lineEmptyCase.add(line * 10 + data);
					
				}
				if (table[data][line].equals("X"))
				{
					colWithoutX = false;
				}
				else if (colWithoutX && table[data][line].equals(" "))
				{
					lineEmptyCase.add(10 * data + line);
					
				}
			}
			if (lineWithoutX)
			{
				for (int item = 0; item < lineEmptyCase.size(); item++)
				{
					pointPossibility.put(lineEmptyCase.get(item), pointPossibility.get(lineEmptyCase.get(item)) + 1);
				}
			}
			if (colWithoutX)
			{
				for (int item = 0; item < colEmptyCase.size(); item++)
				{
					pointPossibility.put(colEmptyCase.get(item), pointPossibility.get(colEmptyCase.get(item)) + 1);
				}
			}
			if (line == 0)
			{
				if (diagonalWithoutX)
				{
					for (int item = 0; item < diagonalEmptyCase.size(); item++)
					{
						pointPossibility.put(diagonalEmptyCase.get(item),pointPossibility.get(diagonalEmptyCase.get(item)) + 1);
					}
				}
				if (rDiagonalWithoutX)
				{
					for (int item = 0; item < rDiagonalEmptyCase.size(); item++)
					{
						pointPossibility.put(rDiagonalEmptyCase.get(item), pointPossibility.get(rDiagonalEmptyCase.get(item)) + 1);
					}
				}
			}
		}
		int coordinate = -1;
		int value = 0;
		for (int location : pointPossibility.keySet())
		{
			if (pointPossibility.get(location) > value)
			{
				value = pointPossibility.get(location);
				coordinate = location;
			}
		}
		if (coordinate > -1)
		{
			hasPlayed = true;
			int col = coordinate % 10;
			int line = (int)(coordinate - coordinate % 10) / 10;
			table[line][col] = "O";
		}
		return hasPlayed;
	}
	
	
	public static boolean chooseMultiplayer(Scanner playerAsk)
	{/*ensure a valid answer
	In: player choice
	Out: if the game is multiplayer*/	
		String input = " ";
		while (!input.equals("1") && !input.equals("2"))
		{
			System.out.println("Welcome!\ntype:\n1 to play against IA\n2 to play against another player(hot seat)");
			input = playerAsk.nextLine();
		}
		if (input.equals("2"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static void printMorpion(String[][] table)
	{/*print the grid
	In: the grid
	Out: none*/
		for (int line = 0; line < 3; line++)
		{
			if (line == 0)
			{
				System.out.println(" |1|2|3|");
			}
			for (int data = 0; data < 3; data++)
			{
				if (data == 0)
				{
					System.out.print(line + 1);
				}
				if (data  == 2)
				{
					System.out.print("|" + table[line][data] + "|\n");
				}
				else
				{
					System.out.print("|" + table[line][data]);
				}
			}
		}
	}
	
	
	public static void validInput(String[][] table, boolean player1, Scanner playerAsk, int randomStart, String player1Name, String player2Name, int turn, boolean multiplayer)
	{/*Ask the current player for valid coordinate and ensure they are.
	IN: the grid, player's turn, entry of the current player
	OUT: none*/
		boolean validAnswer = false;
		while (!validAnswer)
		{
			if (!multiplayer || turn % 2 == randomStart)
			{
				System.out.println(player1Name + " ,choisissez votre ligne et colonne (2 chiffres entre 1 et 3):");
			}
			else
			{
				System.out.println(player2Name + " ,choisissez votre ligne et colonne (2 chiffres entre 1 et 3):");
			}
			String playerchoice = playerAsk.nextLine() ;
			if (playerchoice.length() == 2)
			{
				String lineChoice = "" + playerchoice.charAt(0);
				String colChoice = "" + playerchoice.charAt(1);
				if ("123".contains(lineChoice) && "123".contains(colChoice))
				{
					int lineNumber = Integer.valueOf(lineChoice) - 1;//because we ask for between 1 and 3 number and computer start from 0
					int colNumber = Integer.valueOf(colChoice) - 1;//because we ask for between 1 and 3 number and computer start from 0
					if (table[lineNumber][colNumber].equals(" "))
					{
						if (player1 || !multiplayer)
						{
							table[lineNumber][colNumber] = "X";
						}
						else
						{
							table[lineNumber][colNumber] = "O";
						}
						validAnswer = true;
					}
				}
			}
			if (!validAnswer)
			{
				System.out.println("Erreur! entrez des coordonnés valide non occupées!");
			}
			
		}
	}
	
	
	public static void main(String[] arg)
	{/*Main programm*/
		int randomStart = (int)(0.5 + Math.random());
		boolean player1 = true;
		if (randomStart == 0)
		{
		player1 = false; //current player is player1 if true player2 if false
		}
		Scanner playerAsk = new Scanner(System.in);
		boolean multiplayer = chooseMultiplayer(playerAsk);
		System.out.println("tapez le nom du premier joueur");
		String player1Name = playerAsk.nextLine() ;
		String player2Name = "IA";
		if (multiplayer)
		{
			System.out.println("tapez le nom du second joueur");
			player2Name = playerAsk.nextLine() ;
		}
		String[][] table = 
		{{" ", " ", " "},
		{" ", " ", " "},
		{" ", " ", " "}
		};
		boolean winner = false;
		int turn = 0;
		printMorpion(table);
		while (turn < 9 && !winner){
			turn ++;
			if (multiplayer || turn % 2 == randomStart) // player play one turn and computer the other in monoplayer
			{
				validInput(table, player1, playerAsk, randomStart, player1Name, player2Name, turn, multiplayer);
			}
			else if (!multiplayer && turn % 2 == (1 - randomStart)){
				iaPlay(table, turn);
				System.out.println("IA has played!");
			}
			player1 = !player1;
			printMorpion(table);
			winner = winCheck(table, player1, multiplayer, player1Name, player2Name);	
		}
		if (turn == 9 && !winner)
		{
			System.out.println("Jeu plein sans vainqueur: Égalité!");
		}
	}
}
