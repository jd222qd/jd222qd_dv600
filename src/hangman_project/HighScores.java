package hangman_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This class will handle all the highscore related 
 * @author johandahlberg
 *
 */

public class HighScores {
	
	HangmanMenus menus = new HangmanMenus();
	
	private int highscore = 0;
	private int value = 0;
	private ArrayList<String> names = new ArrayList<String>(10);
	private ArrayList<Integer> scores = new ArrayList<Integer>(10);
	
	public HighScores() {
		
	}
	
	/**
	 * Returns the current highscore.
	 * @return the highscore
	 */
	public int getHighScore() {
		return highscore;
	}
	
	/**
	 * Returns the player name of the corresponding index
	 * @param index the index of the player name
	 * @return the player name
	 */
	public String getName(int index) {
		return names.get(index);
	}
	
	/**
	 * Returns the score of the corresponding index
	 * @param index the index of the score
	 * @return the score
	 */
	public int getScore(int index) {
		return scores.get(index);
	}
	
	/**
	 * Reads the text file containing the highscore list and saves the names and scores in 2 arraylists.
	 * @throws IOException if file cannot be found.
	 */
	public void readFile() {
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/hangman_project/"
				+ "text_files/highscores.txt"));
			String line = reader.readLine();
			while (line != null) {
				if (value == 0 && names.size() < 10) {
					names.add(line);
					value = 1;
				}
				else if (scores.size() < 10){
					scores.add(Integer.valueOf(line));
					value = 0;
				}
				line = reader.readLine();
			}
				
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints the current top 10 high scores.
	 * @throws InterruptedException
	 */
	public void printHighScores() throws InterruptedException
	{
		readFile();
		System.out.println("Player | Score" + "\n");
		for (int i = 0; i < 10; i++) {
			System.out.println(names.get(i) + " - " + scores.get(i));
		}
		System.out.println("\n" + "1) Back to Main Menu");
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
		if(choice.equals("1")) {
			menus.printMainMenu();
		}
		else {
			System.out.println("Wrong input, only 1 allowed! Try again!" );
			TimeUnit.SECONDS.sleep(1);
			printHighScores();
		}
		in.close();
	}

	/**
	 * Updates the text file with the new highscores.
	 * @param name the name of the player who got the new highscore
	 * @throws InterruptedException
	 */
	public void updateHighScores(String name)throws InterruptedException {
		readFile();
		
		for (int i = 0; i < 10; i++) {
			if (highscore > scores.get(i)) {
				if (scores.size() == 10)
				scores.remove(9);
				scores.add(i, highscore);
				if(names.size() == 10)
				names.remove(9);
				names.add(i, name);
				i = 10;
			}
			
			BufferedWriter update;
			try {
				update = new BufferedWriter(new FileWriter("src/hangman_project/text_files/highscores.txt"));
				for(int j = 0; j < 10; j++) {
					update.write(names.get(j) + "\n" + scores.get(j) + "\n");
				}
				update.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Calculates the score for the player after the game has been won.
	 * @param difficulty the difficulty played on
	 * @param guessesLeft the amount of guesses left when won
	 */
	public void calculateScore(String difficulty, int guessesLeft) {
		
		if(difficulty.equals("Easy")) {
			highscore = 50 * guessesLeft;
		}
		else if(difficulty.equals("Medium")) {
			highscore = 75 * guessesLeft;
		}
		else if(difficulty.equals("Hard")) {
			highscore = 100 * guessesLeft;
		}
	}
	
	/**
	 * Prints the option for the player to save his/her score 
	 * @throws InterruptedException
	 */
	public void gameWonMenu() throws InterruptedException {
		
		
		System.out.println("Your score was: " + highscore + ". Do you wish to save your score?" + 
		"\n" + "1) Yes" + "\n" + "2) No");
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
		if(choice.equals("1")) {
			enterPlayerName();
		}
		else if(choice.equals("2")) {
			menus.printMainMenu();
		}
		else {

			System.out.println("Wrong input, only 1-2 allowed! Try again!" );
			TimeUnit.SECONDS.sleep(1);
			gameWonMenu();
		}
		in.close();
	}
	
	/**
	 * Asks the player to enter a name 
	 * @throws InterruptedException
	 */
	public void enterPlayerName() throws InterruptedException {
		System.out.println("Please enter your name (1-10 characters): ");
		Scanner in = new Scanner(System.in);
		String name = in.next();
		if (name.length() > 0 && name.length() < 11) {
			updateHighScores(name);
			menus.printMainMenu();
		}
		else {
			System.out.println("Wrong input, name must be 1-10 characters. Try again!" );
			TimeUnit.SECONDS.sleep(1);
			enterPlayerName();
		}
		in.close();
	}
}
