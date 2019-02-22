package hangman_project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ReadWords {
	
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
