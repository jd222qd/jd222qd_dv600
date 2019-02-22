package hangman_project;

/**
 * @author Johan Dahlberg
 * @since 21-02-2019
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ReadWords {
	
	/**
	 * Reads words from a text file and randomly picks one, also removing any non-letter
	 * characters and converts the word to uppercase.
	 * @return the randomly chosen word
	 */
	public static String getRandomWord()
	{
		String word = "";
		try {
		String wordList = new String(Files.readAllBytes(Paths.get("src/hangman_project/"
				+ "text_files/words.txt")), "UTF-8");
		String[] wordArray = wordList.split(" ");
		Random random = new Random();
		word = wordArray[random.nextInt(wordArray.length -1)].replaceAll("[^a-zA-Z]", "").
				toUpperCase().trim();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return word;
		
	}

}
