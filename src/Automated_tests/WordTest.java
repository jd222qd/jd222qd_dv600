package Automated_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman_project.Word;

class WordTest {
	
private static int test_count = 0;
	
	/* Is executed before every test method (not test case).*/
	@BeforeEach
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count);
	}

	@Test
	void shouldReturnFalseIfNotGuessed() {
		Word sut = new Word();
		assertFalse(sut.contains("a"));
	}
	
	@Test
	void shouldReturnTrueIfGuessed(){
		Word sut = new Word();
		sut.add("a");
		assertTrue(sut.contains("a"));
	}
	
	@Test
	void shouldReturnFalseIfGuessedCleared(){
		Word sut = new Word();
		sut.add("a");
		sut.clear();
		assertFalse(sut.contains("a"));
	}
	
	@Test
	void allCharactersShouldBeUnderscores(){ //_ _ _ _
		Word sut = new Word();
		sut.setupWord();
		sut.printUnderscores();
		for (int i = 0; i < sut.getWordLetters().length; i++) {
			String actual = sut.getWordLetters()[i];
			String expected ="_";
			assertEquals(actual, expected);
		}
	}
	
	@Test
	void allCharactersExceptTShouldBeUnderscores(){ //T _ _ T
		Word sut = new Word();
		sut.setupWord();
		sut.updateWordLetters("T");
			String actual = sut.getWordLetters()[0];
			String expected = "T";
			assertEquals(actual, expected);
			actual = sut.getWordLetters()[1];
			expected = "_";
			assertEquals(actual, expected);
			actual = sut.getWordLetters()[2];
			expected = "_";
			assertEquals(actual, expected);
			actual = sut.getWordLetters()[3];
			expected = "T";
			assertEquals(actual, expected);	
	}
	
	@Test
	void shouldReturnTrueIfFinished(){ //T E S T
		Word sut = new Word();
		sut.setupWord();
		sut.updateWordLetters("T");
		sut.updateWordLetters("E");
		sut.updateWordLetters("S");
		
		assertTrue(sut.checkIfWordFinished());	
	}
	
	@Test
	void shouldReturnFalseIfNotFinished(){ //T E S T
		Word sut = new Word();
		sut.setupWord();
		assertFalse(sut.checkIfWordFinished());	
	}
	
	@Test
	void shouldReturnTEST(){ //T E S T
		Word sut = new Word();
		sut.setupWord();
		assertEquals(sut.getWord(), "TEST");	
	}

}
