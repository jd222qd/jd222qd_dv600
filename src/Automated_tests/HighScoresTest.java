package Automated_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hangman_project.HighScores;

class HighScoresTest {

	@Test
	void shouldNotReturnNull() {
		
		HighScores sut = new HighScores();
		assertTrue(sut.getHighScores() != null);
	}

}
