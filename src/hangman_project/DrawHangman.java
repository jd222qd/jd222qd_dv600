package hangman_project;

/**
 * This class handles the drawing of the hangman when playing the game.
 * 
 * @author Johan Dahlberg
 *
 */

public class DrawHangman {
	
	public DrawHangman() {
		
	}
	
	/**
	 * Prints the hangman depending on difficulty and amount of guesses left.
	 * @param difficulty the current game difficulty
	 * @param guessesleft the amount of guesses left
	 * @return the number of guesses left (used for testing)
	 */
	public int printHangMan(String difficulty, int guessesLeft) {
		
		if(difficulty.equals("Easy")) { 
			if(guessesLeft == 12) {
				System.out.println(
						"    			\n" + 
						"   	 		\n" + 
						"   			\n" + 
						"   			\n" + 
						"   			\n" + 
						"   			\n" + 
						"  				\n" + 
						"   			 \n" + 
						" |          |  \n" + 
						" |__________|");
				return 12;
			}
			else if(guessesLeft == 11) {
				System.out.println(
						"    			\n" + 
						"   	 		\n" + 
						"   			\n" + 
						"   			\n" + 
						"   			\n" + 
						"   			\n" + 
						"  				\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 11;
			}
			else if(guessesLeft == 10) {
				System.out.println(
						"    			\n" + 
						"   	 		\n" + 
						"   			\n" + 
						"   			\n" + 
						"   			\n" + 
						"   			\n" + 
						"  _ _			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 10;
			}
			else if(guessesLeft == 9) {
				System.out.println(
						"    			\n" + 
						"    	 		\n" + 
						"    	 		\n" + 
						"    			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 9;
			}
			else if(guessesLeft == 8) {
				System.out.println(
						"    			\n" + 
						"   | 	 		\n" + 
						"   | 	 		\n" + 
						"   | 			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 8;
			}
			else if(guessesLeft == 7) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 		\n" + 
						"   | 			\n" + 
						"   | 			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 7;
			}
			else if(guessesLeft == 6) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 		\n" + 
						"   | 			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 6;
			}
			else if(guessesLeft == 5) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	 		\n" + 
						"   |	 		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 5;
			}
			else if(guessesLeft == 4) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	 | 		\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 4;
			}
			else if(guessesLeft == 3) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/| 		\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 3;
			}
			else if(guessesLeft == 2) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\ 	\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 2;
			}
			else if(guessesLeft == 1) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\ 	\n" + 
						"   |	 |		\n" + 
						"   | 	/		\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 1;
			}
			else if(guessesLeft == 0) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\ 	\n" + 
						"   |	 |		\n" + 
						"   | 	/ \\	\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 0;
			}
		}
		else if(difficulty.equals("Medium")) {
			if(guessesLeft == 9) {
				System.out.println(
						"    			\n" + 
						"   	 		\n" + 
						"   			\n" + 
						"   			\n" + 
						"   			\n" + 
						"   			\n" + 
						"  _ _			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 9;
			}
			else if(guessesLeft == 8) {
				System.out.println(
						"    			\n" + 
						"   | 	 		\n" + 
						"   | 	 		\n" + 
						"   | 			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 8;
			}
			else if(guessesLeft == 7) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 		\n" + 
						"   | 			\n" + 
						"   | 			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 7;
			}
			else if(guessesLeft == 6) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 		\n" + 
						"   | 			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 6;
			}
			else if(guessesLeft == 5) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	 		\n" + 
						"   |	 		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 5;
			}
			else if(guessesLeft == 4) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	 | 		\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 4;
			}
			else if(guessesLeft == 3) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/| 		\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 3;
			}
			else if(guessesLeft == 2) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\ 	\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 2;
			}
			else if(guessesLeft == 1) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\ 	\n" + 
						"   |	 |		\n" + 
						"   | 	/		\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 1;
			}
			else if(guessesLeft == 0) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\ 	\n" + 
						"   |	 |		\n" + 
						"   | 	/ \\	\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 0;
			}
		}
		else if(difficulty.equals("Hard")) {
			if(guessesLeft == 6) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 			\n" + 
						"   | 			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 6;
			}
			else if(guessesLeft == 5) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 			\n" + 
						"   |			\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 5;
			}
			else if(guessesLeft == 4) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	 |		\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 4;
			}
			else if(guessesLeft == 3) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|		\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 3;
			}
			else if(guessesLeft == 2) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\	\n" + 
						"   |	 |		\n" + 
						"   | 			\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 2;
			}
			else if(guessesLeft == 1) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\	\n" + 
						"   |	 |		\n" + 
						"   | 	/		\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 1;
			}
			else if(guessesLeft == 0) {
				System.out.println(
						"    _____		\n" + 
						"   | 	 |		\n" + 
						"   | 	 o		\n" + 
						"   | 	/|\\	\n" + 
						"   |	 |		\n" + 
						"   | 	/ \\	\n" + 
						"  _|_			\n" + 
						" |   |______   \n" + 
						" |          |  \n" + 
						" |__________|");
				return 0;
			}
		}
		return -1;
	}

}
