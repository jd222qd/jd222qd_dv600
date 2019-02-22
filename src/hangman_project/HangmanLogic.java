package hangman_project;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

public class HangmanLogic {
	
	private static String previous = "";
	private static int guessesLeft = 0;
	private static List<String> guessedLetters = new ArrayList<String>();
	private static String[] wordLetters;
	private static String word = "";
	
	public static void welcomeText() throws InterruptedException
	{
		System.out.println("Welcome to the Hangman game!");
		TimeUnit.SECONDS.sleep(2);
		printMainMenu();
	}
	
	private static void printMainMenu() throws InterruptedException
	{
		System.out.println("Main Menu" + "\n" + "1) Start Game" + "\n" + "2) Check Highscores"
			    + "\n" + "3) Quit Application");
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
		if(choice.equals("1")) {
			printDifficulties();
		}
		else if(choice.equals("2")) {
			printHighScores();
		}
		else if(choice.equals("3")) {
			previous = "Main";
			if(confirmTermination()) {
				in.close();
				return;
			}
		}
		else {

			System.out.println("Wrong input, only 1-3 allowed! Try again!" );
			TimeUnit.SECONDS.sleep(1);
			printMainMenu();
		}
		in.close();
	}
	
	private static void printDifficulties() throws InterruptedException
	{
		System.out.println("Choose Difficulty" + "\n" + "1) Easy" + "\n" + "2) Medium"
			    + "\n" + "3) Hard" + "\n" + "4) Back to Main Menu");
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
		if(choice.equals("1")) {
			launchGame("Easy");
		}
		else if(choice.equals("2")) {
			launchGame("Medium");
		}
		else if(choice.equals("3")) {
			launchGame("Hard");
		}
		else if(choice.equals("4")) {
			printMainMenu();
		}
		else {

			System.out.println("Wrong input, only 1-4 allowed! Try again!" );
			TimeUnit.SECONDS.sleep(1);
			printDifficulties();
		}
		in.close();
	}
	
	private static void printUnderscores() 
	{
		for(int i = 0; i < word.length(); i++) {
			System.out.print(wordLetters[i] + " ");
		}
	}
	
	private static boolean confirmTermination() throws InterruptedException
	{
		System.out.println("Are you sure you want to quit the application?" + "\n" + "1) Yes" + "\n" + "2)"
				+ " No");
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
		
		if(choice.equals("1")) {
			in.close(); 
			return true;
		}
		else if(choice.equals("2") && previous.equals("Main")) {
			printMainMenu();
		}
		else if(choice.equals("2") && previous.equals("Game")) {
			guessLetter();
		}
		else {
			System.out.println("Wrong input, only 1-2 allowed! Try again!" );
			TimeUnit.SECONDS.sleep(1);
			confirmTermination();
			
		}
		in.close();
		return false;
	}
	
	private static void launchGame(String difficulty) throws InterruptedException
	{
		
		if (difficulty.equals("Easy")) {
			guessesLeft = 13;
		}
		else if (difficulty.equals("Medium")) {
			guessesLeft = 10;
		}
		else if (difficulty.equals("Hard")){
			guessesLeft = 7;
		}
		
		word = ReadWords.getRandomWord();
		wordLetters = new String[word.length()];
		//System.out.println(word);
		for(int i = 0; i < word.length(); i++) {
			wordLetters[i] = "_";
		}
		guessLetter();
	}
	
	private static void guessLetter() throws InterruptedException 
	{
		previous = "Game";
		
		if(guessesLeft <= 0) {
			System.out.println("You lost, sorry! The word was: " + word);
			guessedLetters.clear();
			TimeUnit.SECONDS.sleep(3);
			printMainMenu();
		}
		else {
			printUnderscores();
			System.out.println();
			System.out.println("Guess a letter! (" + guessesLeft + " guesses left)"  + "\n" 
			+ "1) Back to Main Menu" + "\n" + "2) Quit Application)");
			Scanner in = new Scanner(System.in);
			String choice = in.next();
			choice = choice.toUpperCase();
			
			if (choice.equals("1")) {
				guessedLetters.clear();
				printMainMenu();
			}
			else if (choice.equals("2")) {
				confirmTermination();
			}
			else if(choice.equals("Å") || choice.equals("Ä") || choice.equals("Ö")) {
				System.out.println("Wrong input, only a-z & 1-2 allowed! Try again!" );
				TimeUnit.SECONDS.sleep(1);
				guessLetter();
			}
			else if(Character.isLetter(choice.charAt(0)) && choice.length() == 1 && 
					guessedLetters.contains(choice)) {
				System.out.println("Letter already guessed, try again!");
				TimeUnit.SECONDS.sleep(1);
				guessLetter();
			}
			else if(Character.isLetter(choice.charAt(0)) && choice.length() == 1) {
				guessedLetters.add(choice);
				if(word.contains(choice)) {
					updateWordLetters(choice);
					if(checkIfWordFinished()) {
						printUnderscores();
						System.out.println();
						System.out.println("You won, congratulations!");
						TimeUnit.SECONDS.sleep(3);
						printMainMenu();
						//add more later
					}
					else {
						guessLetter();
					}
				}
				else {
					guessesLeft--;
					guessLetter();
				}
			}
			else {
				System.out.println("Wrong input, only a-z & 1-2 allowed! Try again!" );
				TimeUnit.SECONDS.sleep(1);
				guessLetter();
			}
			in.close();
		}
		
	}
	
	private static boolean checkIfWordFinished() {
		
		for(int i = 0; i < word.length(); i++) {
			if(wordLetters[i].equals("_"))
				return false;
		}
		previous = "Main";
		guessedLetters.clear();
		return true;
	}
	
	private static void updateWordLetters(String letter) {
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == (letter.charAt(0))) {
				wordLetters[i] = letter;
			}
		}
	}
	
	private static void printHighScores() throws InterruptedException
	{
		System.out.println("Feature not added yet, returning to Main Menu!");
		TimeUnit.SECONDS.sleep(1);
		printMainMenu();
	}
	

	
	

}
