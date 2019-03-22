package Automated_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman_project.HighScores;

class HighScoresTest {
	
private static int test_count = 0;
	
	/* Is executed before every test method (not test case).*/
	@BeforeEach
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count);
	}

	@Test
	void shouldReturnZero() {
		
		HighScores sut = new HighScores();
		assertEquals(sut.getHighScore(), 0);
	} 
	
	@Test
	void shouldNotReturnNullOrNegativeInteger() {
		
		HighScores sut = new HighScores();
		sut.readFile();
		for (int i = 0; i < 10; i++) {
			assertTrue(sut.getName(i) != null);
			assertTrue(sut.getScore(i) > -1);
		}
	} 
	
	@Test
	void shouldReturn50() {
		HighScores sut = new HighScores();
		sut.calculateScore("Easy", 1);
		assertEquals(sut.getHighScore(), 50);
	} 
	
	@Test
	void shouldReturn75() {
		HighScores sut = new HighScores();
		sut.calculateScore("Medium", 1);
		assertEquals(sut.getHighScore(), 75);
	} 
	
	@Test
	void shouldReturn100() {
		HighScores sut = new HighScores();
		sut.calculateScore("Hard", 1);
		assertEquals(sut.getHighScore(), 100);
	} 

}
