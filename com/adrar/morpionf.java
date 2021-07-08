package com.adrar;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;


public class morpionf
{/*Author: thannajo
	date 07 may 2021
	version : 2.0
	purpose: a noughts and crosses game for 2 players
	IN: a series of instruction of 2 digits representing the row and col represented by a string of the current player
	OUT: print on screen Instruction for the player, the grid of the game, the winner if any or tie.*/
	
	
	public static boolean winCheck(String[][] table, boolean player1, String player1Name, String player2Name)
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

				}
				else
				{
					System.out.println(player1Name+" win!");
				}
				return true;
			}
		
		}
		return false;
	}
	
	
	public static void iaPlay(String [][] table, int turn, String IASymbol)
	{/* make the IA play following the following pattern: play the winning possibility if any, else avoid the winning possibility of the player else play something else
		IN:turn number, the grid
		OUT: modify the grid accordingly*/
		String otherSymbol = IASymbol.equals("X") ? "O" : "X";
		try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println("interrupted");}
		if (turn < 3)
		{
			if (table[1][1].equals(" "))
			{
				table[1][1] = IASymbol;
			}
			else
			{
				table[0][0] = IASymbol;
			}
		}
		else 
		{
			boolean hasPlayed;
			hasPlayed = requiredPlay(table, IASymbol, IASymbol); //IA play if it can win!
			if (!hasPlayed)
			{
				hasPlayed = requiredPlay(table, otherSymbol, IASymbol);//IA play for not loosing
			}
			if (!hasPlayed)
			{
				hasPlayed = selectBestChoice(table, IASymbol, otherSymbol);
			}
			if (!hasPlayed)
			{
				fillingPlay(table, IASymbol);//no winning possibility IA just fill a case
			}
		}
	}
	
	
	public static boolean requiredPlay(String[][] table, String toCheck, String IASymbol)
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
				table[lineEmptyCoordinaterow][lineEmptyCoordinatecol] = IASymbol;
				hasPlayed = true;
			}
			else if (colOCount == 2 && colEmptyCount == 1 )
			{
				table[colEmptyCoordinaterow][colEmptyCoordinatecol] = IASymbol;
				hasPlayed = true;
			}
			else if (diagonalOcount == 2 && diagonalEmptyCount == 1 )
			{
				table[diagonalEmptyCoordinate][diagonalEmptyCoordinate] = IASymbol;
				hasPlayed = true;
			}
			else if (rDiagonalOcount == 2 && rDiagonalEmptyCount == 1 )
			{
				table[rDiagonalEmptyCoordinate][2-rDiagonalEmptyCoordinate] = IASymbol;
				hasPlayed = true;
			}
			if (hasPlayed)
			{
				break;
			}
		}
		return hasPlayed;
	}
	
	
	public static void fillingPlay(String[][] table, String IASymbol)
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
					table[line][data] = IASymbol;
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
	
	
	public static boolean selectBestChoice(String[][] table, String IASymbol, String OtherSymbol)
	{/* in case of non winning or non losing turn check the best answer if any
		IN:the grid
		OUT: cross the first best case, return true if played, false else*/
		boolean hasPlayed = false;
		HashMap<Integer,Integer> pointPossibility = new HashMap<>();
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
			ArrayList<Integer> lineEmptyCase = new ArrayList<>();
			ArrayList<Integer> colEmptyCase = new ArrayList<>();
			ArrayList<Integer> diagonalEmptyCase = new ArrayList<>();
			ArrayList<Integer> rDiagonalEmptyCase = new ArrayList<>();
			boolean lineWithoutX = true;
			boolean colWithoutX = true;
			boolean diagonalWithoutX = true;
			boolean rDiagonalWithoutX = true;
			for (int data = 0; data < 3; data++)
			{
				if (line == 0)
				{
					if (table[data][data].equals(OtherSymbol))
					{
						diagonalWithoutX = false;
					}
					else if (diagonalWithoutX && table[data][data].equals(" "))
					{
						diagonalEmptyCase.add(data * 11);
					}
					if (table[data][2-data].equals(OtherSymbol))
					{
						rDiagonalWithoutX = false;
					}
					else if (rDiagonalWithoutX && table[data][2-data].equals(" "))
					{
						rDiagonalEmptyCase.add(data * 10 + (2-data));
					}
				}
				if (table[line][data].equals(OtherSymbol))
				{
					lineWithoutX = false;
				}
				else if (lineWithoutX && table[line][data].equals(" "))
				{
					lineEmptyCase.add(line * 10 + data);
					
				}
				if (table[data][line].equals(OtherSymbol))
				{
					colWithoutX = false;
				}
				else if (colWithoutX && table[data][line].equals(" "))
				{
					colEmptyCase.add(10 * data + line);
					
				}
			}
			if (lineWithoutX)
			{
				for (Integer integer : lineEmptyCase) {
					pointPossibility.put(integer, pointPossibility.get(integer) + 1);
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
			int line = (coordinate - coordinate % 10) / 10;
			table[line][col] = IASymbol;
		}
		return hasPlayed;
	}
	
	
	public static String chooseMultiplayer(Scanner playerAsk)
	{/*ensure a valid answer
	In: player choice
	Out: if the game is multiplayer*/	
		String input = " ";
		while (!input.equals("1") && !input.equals("2") && !input.equals("3"))
		{
			System.out.println("Welcome!\ntype:\n1 to play against IA\n2 to play against another player(hot seat)\n3 3 for two IA to compete against each other");
			input = playerAsk.nextLine();
		}
		return input;
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
	
	
	public static void validInput(String[][] table, Scanner playerAsk, int randomStart, String player1Name, String player2Name, int turn, String multiplayer)
	{/*Ask the current player for valid coordinate and ensure they are.
	IN: the grid, player's turn, entry of the current player
	OUT: none*/
		boolean validAnswer = false;
		while (!validAnswer)
		{
			if (multiplayer.equals("1") || turn % 2 == randomStart)
			{
				System.out.println(player1Name + " ,choisissez votre ligne et colonne (2 chiffres entre 1 et 3):");
			}
			else if (multiplayer.equals("2") && turn % 2 != randomStart)
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
					int lineNumber = parseInt(lineChoice) - 1;//because we ask for between 1 and 3 number and computer start from 0
					int colNumber = parseInt(colChoice) - 1;//because we ask for between 1 and 3 number and computer start from 0
					if (table[lineNumber][colNumber].equals(" "))
					{
						if (turn % 2 == randomStart)
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
		boolean player1 = randomStart == 1;
		Scanner playerAsk = new Scanner(System.in);
		String multiplayer = chooseMultiplayer(playerAsk);
		String player1Name = "IAfirst";
		if (!multiplayer.equals("3")) {
			System.out.println("tapez le nom du premier joueur");
			player1Name = playerAsk.nextLine();
		}
		String player2Name = multiplayer.equals("3") ? "IAsecond" : "IA";
		if (multiplayer.equals("2"))
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
			if (multiplayer.equals("2") || multiplayer.equals("1") && turn % 2 == randomStart) // player play one turn and computer the other in monoplayer
			{
				validInput(table, playerAsk, randomStart, player1Name, player2Name, turn, multiplayer);
			}
			else if (multiplayer.equals("1") && turn % 2 == (1 - randomStart) || multiplayer.equals("3")){
				String IASymbol = turn % 2 == randomStart ? "X" : "O";
				iaPlay(table, turn, IASymbol);
				if (multiplayer.equals("3")){
					if (turn % 2 == randomStart ){
						System.out.println(player1Name+" has played!");
					}
					else {
						System.out.println(player2Name+" has played!");
					}
				}
				else{
					System.out.println("IA has played!");
				}

			}
			player1 = !player1;
			printMorpion(table);
			winner = winCheck(table, player1, player1Name, player2Name);
		}
		if (turn == 9 && !winner)
		{
			System.out.println("Jeu plein sans vainqueur: Égalité!");
		}
	}
}
