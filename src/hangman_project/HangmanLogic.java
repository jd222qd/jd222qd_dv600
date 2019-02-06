package hangman_project;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HangmanLogic {
	
	
	public static void welcomeText() throws InterruptedException
	{
		System.out.println("Welcome to the Hangman game!");
		TimeUnit.SECONDS.sleep(2);
		printMainMenu();
	}
	
	public static void printMainMenu()
	{
		System.out.println("Main Menu" + "\n" + "1) Start Game" + "\n" + "2) Check Highscores"
			    + "\n" + "3) Quit Game");
	}
	
	public static void printDifficulties() 
	{
		
	}
	
	public static void printHighscores() 
	{
		
	}
	
	public static void clearScreen()
	{
		
	}

}
