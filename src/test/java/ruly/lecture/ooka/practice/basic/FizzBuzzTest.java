package ruly.lecture.ooka.practice.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
	private final FizzBuzz fb = new FizzBuzz();

	@Test
	@DisplayName("3の倍数の時にFizzを返すこと")
	void testFizz() {
		assertEquals("Fizz", fb.convert(3));
		assertEquals("Fizz", fb.convert(9));
	}

	@Test
	@DisplayName("5の倍数の時にBuzzを返すこと")
	void testBuzz() {
		assertEquals("Buzz", fb.convert(5));
		assertEquals("Buzz", fb.convert(10));
	}

	@Test
	@DisplayName("3と5の両方の倍数の時にFizzBuzzを返すこと")
	void testFizzBuzz() {
		assertEquals("FizzBuzz", fb.convert(15));
		assertEquals("FizzBuzz", fb.convert(30));
	}

	@Test
	@DisplayName("それ以外の数字は文字列として返すこと")
	void testNumber() {
		assertEquals("1", fb.convert(1));
		assertEquals("2", fb.convert(2));
		assertEquals("4", fb.convert(4));
	}
}
