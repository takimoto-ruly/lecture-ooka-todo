package ruly.lecture.ooka.practice.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {
	private final StringProcessor processor = new StringProcessor();

	@Test
	@DisplayName("文字列の繰り返しが正しく行われること")
	void testRepeatString() {
		assertEquals("abcabcabc", processor.repeatString("abc", 3));
		assertEquals("A", processor.repeatString("A", 1));
		assertEquals("", processor.repeatString("test", 0));
		assertEquals("", processor.repeatString("test", -1));
	}

	@Test
	@DisplayName("文字列内の特定の文字数が正しくカウントされること")
	void testCountChar() {
		assertEquals(3, processor.countChar("apple pie", 'p'));
		assertEquals(2, processor.countChar("banana", 'a'));
		assertEquals(0, processor.countChar("hello", 'z'));
		assertEquals(0, processor.countChar("", 'a'));
	}
}
