package ruly.lecture.ooka.practice.instance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class C02_PersonWithAgeTest {
	@Test
	@DisplayName("コンストラクタで名前と年齢が正しく初期化されること")
	void testConstructor() {
		C02_PersonWithAge p = new C02_PersonWithAge("高橋", 25);
		assertEquals("高橋", p.name);
		assertEquals(25, p.age);
	}

	@Test
	@DisplayName("誕生日を祝うと年齢がインクリメントされること")
	void testBirthday() {
		C02_PersonWithAge p = new C02_PersonWithAge("高橋", 25);
		p.celebrateBirthday();
		assertEquals(26, p.age, "年齢が1増えていなといけません");
	}
}
