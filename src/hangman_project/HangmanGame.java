package hangman_project;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This class is used to represent a round of the hangman game.
 * 
 * @author Johan Dahlberg
 *
 */

public class HangmanGame {
	
	private static int guessesLeft = 0;
	private Word word = new Word();
	private HangmanMenus menus = new HangmanMenus();
	
	public HangmanGame() {
		 
	}
	
	/**
	 * Get the amount of guesses left.
	 * @return the amount of guesses left
	 */
	public int guessesLeft() {
		return guessesLeft;
	}
	
	/**
	 * Starts a round of hangman on the given difficulty and picks a random word.
	 * @param difficulty the chosen difficulty
	 * @throws InterruptedException
	 */
	public void launchGame(String difficulty) throws InterruptedException
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
		word.setupWord();
		guessLetter(difficulty);
	}
	
	/**
	 * Asks the user to input a letter, return to main menu or quit application.
	 * Runs like a round of hangman, you either win or lose when enough guesses has
	 * been made.
	 * @throws InterruptedException
	 */
	public void guessLetter(String difficulty) throws InterruptedException 
	{
		HangmanMenus.updatePrevious("Game");
		DrawHangman current_game = new DrawHangman();
		
		if(guessesLeft <= 0) {
			current_game.printHangMan(difficulty, guessesLeft);
			System.out.println();
			System.out.println("You lost, sorry! The word was: " + word.getWord());
			word.clear();
			TimeUnit.SECONDS.sleep(3);
			menus.printMainMenu();
		}
		else {
			current_game.printHangMan(difficulty, guessesLeft);
			System.out.println();
			word.printUnderscores();
			System.out.println();
			System.out.println();
			System.out.println("Guess a letter! (" + guessesLeft + " guesses left)"  + "\n" 
			+ "1) Back to Main Menu" + "\n" + "2) Quit Application)");
			Scanner in = new Scanner(System.in);
			String choice = in.next();
			choice = choice.toUpperCase();
			
			if (choice.equals("1")) {
				word.clear();
				menus.printMainMenu();
			}
			else if (choice.equals("2")) {
				menus.confirmTermination();
			}
			else if(choice.equals("Å") || choice.equals("Ä") || choice.equals("Ö")) {
				System.out.println("Wrong input, only a-z & 1-2 allowed! Try again!" );
				TimeUnit.SECONDS.sleep(1);
				guessLetter(difficulty);
			}
			else if(Character.isLetter(choice.charAt(0)) && choice.length() == 1 && 
					word.contains(choice)) {
				System.out.println("Letter already guessed, try again!");
				TimeUnit.SECONDS.sleep(1);
				guessLetter(difficulty);
			}
			else if(Character.isLetter(choice.charAt(0)) && choice.length() == 1) {
				word.add(choice);
				if(word.getWord().contains(choice)) {
					word.updateWordLetters(choice);
					if(word.checkIfWordFinished()) {
						word.printUnderscores();
						System.out.println();
						System.out.println("You won, congratulations!");
						TimeUnit.SECONDS.sleep(3);
						menus.printMainMenu();
						//add more later
					}
					else {
						guessLetter(difficulty);
					}
				}
				else {
					guessesLeft--;
					guessLetter(difficulty);
				}
			}
			else {
				System.out.println("Wrong input, only a-z & 1-2 allowed! Try again!" );
				TimeUnit.SECONDS.sleep(1);
				guessLetter(difficulty);
			}
			in.close();
		}
		
	}

}
