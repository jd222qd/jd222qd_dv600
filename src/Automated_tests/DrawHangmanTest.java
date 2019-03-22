package Automated_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman_project.DrawHangman;

class DrawHangmanTest {
	
private static int test_count = 0; 

	DrawHangman test;
	
	/* Is executed before every test method (not test case).*/
	@BeforeEach
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count); 
	}


	@Test
	void shouldDrawAllHangmanStagesOnEasy() {
		
		DrawHangman sut = new DrawHangman();
		for (int i = 0; i < 12; i++) {
		assertEquals(sut.printHangMan("Easy", i), i);
		assertTrue(sut.printHangMan("Easy", i) < i+1);
		}
	}
	@Test
	void shouldDrawAllHangmanStagesOnMedium() {
		DrawHangman sut = new DrawHangman();
		for (int i = 0; i < 9; i++) {
		assertEquals(sut.printHangMan("Medium", i), i);
		assertTrue(sut.printHangMan("Medium", i) < i+1);
		}
	}
	
	@Test
	void shouldDrawAllHangmanStagesOnHard() {
		DrawHangman sut = new DrawHangman();
		for (int i = 0; i < 6; i++) {
		assertEquals(sut.printHangMan("Hard", i), i);
		assertTrue(sut.printHangMan("Hard", i) < i+1);
		}
	}

}
