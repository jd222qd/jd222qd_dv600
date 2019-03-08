package hangman_project;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the related operations on the word used in the hangman game.
 * 
 * @author Johan Dahlberg
 *
 */

public class Word {
	
	private static String word;
	private static String[] wordLetters;
	private static List<String> guessedLetters = new ArrayList<String>();
	
	public Word() {
		
	}
	
	/**
	 * Gets the chosen word.
	 * @return the chosen word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Gets the array containing the letters of the word
	 * @return the array containing the letters of the word
	 */
	public String[] getWordLetters() {
		return wordLetters;
	}
	
	/**
	 * Adds a letter to the guessedLetters array.
	 * @param letter the letter to be added to the array
	 */
	public void add(String letter) {
		guessedLetters.add(letter);
	}
	
	/**
	 * Checks if the guessedLetters array contains the letter
	 * @param letter the letter to check for
	 * @return true if the array contains the letter
	 */
	public boolean contains(String letter) {
		return guessedLetters.contains(letter);
	}
	
	/**
	 * Clears the guessedLetters array.
	 */
	public void clear() {
		guessedLetters.clear();
	}
	
	/**
	 * Picks a random word and stores the characters as underscores in the wordLetters array.
	 */
	public void setupWord() {
		
		word = ReadWords.getRandomWord();
		wordLetters = new String[word.length()];
		//System.out.println(word);
		for(int i = 0; i < word.length(); i++) {
			wordLetters[i] = "_";
		}
	}
	
	/**
	 * Prints the randomly chosen word in underscores.
	 */
	public void printUnderscores() 
	{
		for(int i = 0; i < word.length(); i++) {
			System.out.print(wordLetters[i] + " ");
		}
	}
	
	/**
	 * Updates the wordLetters array with the guessed letter.
	 * @param letter the guessed letter
	 */
	public void updateWordLetters(String letter) {
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == (letter.charAt(0))) {
				wordLetters[i] = letter;
			}
		}
	}
	
	/**
	 * Checks if the word is completed.
	 * @return true if word is completed
	 */
	public boolean checkIfWordFinished() {
		
		for(int i = 0; i < word.length(); i++) {
			if(wordLetters[i].equals("_"))
				return false;
		}
		HangmanMenus.updatePrevious("Main");
		clear();
		return true;
	}

}
