package hangman_project;

import java.util.Scanner;

/**
 * This class holds the menus of the hangman game.
 * 
 * @author Johan Dahlberg
 * @since 21-02-2019
 */

import java.util.concurrent.TimeUnit;

public class HangmanMenus {
	
	private static String previous = "";
	private static String difficulty = "";
	
	public HangmanMenus() { 

	}
	
	/**
	 * Welcomes the user when the game is started and calls the printMainMenu method.
	 * @throws InterruptedException
	 */
	public void welcomeText() throws InterruptedException
	{
		System.out.println("Welcome to the Hangman game!");
		TimeUnit.SECONDS.sleep(2);
		printMainMenu();
	}
	
	/**
	 * Updates the previous variables.
	 * @param p the new string value of the previous variable
	 */
	public static void updatePrevious(String p) {
		previous = p;
	}

	/**
	 * Prints the main menu with different options.
	 * @throws InterruptedException
	 */
	public void printMainMenu() throws InterruptedException
	{
		HighScores scores = new HighScores();
		System.out.println("Main Menu" + "\n" + "1) Start Game" + "\n" + "2) Check Highscores"
			    + "\n" + "3) Quit Application");
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
		if(choice.equals("1")) {
			printDifficulties();
		}
		else if(choice.equals("2")) {
			scores.printHighScores();
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
	
	/**
	 * Prints the difficulties with different options.
	 * @throws InterruptedException
	 */
	public void printDifficulties() throws InterruptedException
	{
		HangmanGame game = new HangmanGame();
		System.out.println("Choose Difficulty" + "\n" + "1) Easy" + "\n" + "2) Medium"
			    + "\n" + "3) Hard" + "\n" + "4) Back to Main Menu");
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
		if(choice.equals("1")) {
			difficulty = "Easy";
			game.launchGame(difficulty);
		}
		else if(choice.equals("2")) {
			difficulty = "Medium";
			game.launchGame(difficulty);
		}
		else if(choice.equals("3")) {
			difficulty = "Hard";
			game.launchGame(difficulty);
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
	
	/**
	 * Asks the user to confirm termination of the application.
	 * @return true if termination confirmed
	 * @throws InterruptedException
	 */
	public boolean confirmTermination() throws InterruptedException
	{
		HangmanGame game = new HangmanGame();
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
			game.guessLetter(difficulty);
		}
		else {
			System.out.println("Wrong input, only 1-2 allowed! Try again!" );
			TimeUnit.SECONDS.sleep(1);
			confirmTermination();
			
		}
		in.close();
		return false;
	}
}
