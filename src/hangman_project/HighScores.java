package hangman_project;

import java.util.concurrent.TimeUnit;

/**
 * This class will handle all the highscore related 
 * @author johandahlberg
 *
 */

public class HighScores {
	
	HangmanMenus menus = new HangmanMenus();
	
	public HighScores() {
		
	}
	
	/**
	 * Will print the current top 10 high scores (not yet implemented)
	 * @throws InterruptedException
	 */
	public void printHighScores() throws InterruptedException
	{
		System.out.println("Feature not added yet, returning to Main Menu!");
		TimeUnit.SECONDS.sleep(1);
		menus.printMainMenu();
	}
	/**
	 * Code has not yet been implemented (test will fail)
	 * @return null;
	 */
	public String getHighScores() {
		return null;
	}
	
	/**
	 * Correct implementation (test will succeed)
	 * @return scores the highscores
	 */
	/*public String getHighScores() {
		String scores = "Player 1: 120" + "/n" + "Player 2: 50" ;
		return scores;
	}*/

}
