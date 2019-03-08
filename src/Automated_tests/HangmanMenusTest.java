package Automated_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman_project.HangmanMenus;

class HangmanMenusTest {
	
	private static int test_count = 0;
	
	/* Is executed before every test method (not test case).*/
	@BeforeEach
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count);
	}

	@Test
	void test() throws InterruptedException{
		HangmanMenus sut = new HangmanMenus();
		System.setIn(new ByteArrayInputStream("1".getBytes()));
		assertTrue(sut.confirmTermination());
	}
}
