package Automated_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman_project.HangmanGame;

class HangmanGameTest {
	
private static int test_count = 0;
	
	/* Is executed before every test method (not test case).*/
	@BeforeEach
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count);
	}

	@Test
	void shouldReturnZeroIfGameHasNotBeenLaunched() {
		HangmanGame sut = new HangmanGame();
		assertEquals(0, sut.guessesLeft());
	}
	


}
