package ruly.lecture.ooka.practice.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FortuneUtilTest {
	private final FortuneUtil util = new FortuneUtil();

	@ParameterizedTest
	@DisplayName("各星座の期間開始日と終了日で正しく判定されること")
	@CsvSource({
		"12, 22, 山羊座", "1, 19, 山羊座",
		"1, 20, 水瓶座",  "2, 18, 水瓶座",
		"2, 19, 魚座",    "3, 20, 魚座",
		"3, 21, 牡羊座",  "4, 19, 牡羊座",
		"4, 20, 牡牛座",  "5, 20, 牡牛座",
		"5, 21, 双子座",  "6, 21, 双子座",
		"6, 22, 蟹座",    "7, 22, 蟹座",
		"7, 23, 獅子座",  "8, 22, 獅子座",
		"8, 23, 乙女座",  "9, 22, 乙女座",
		"9, 23, 天秤座",  "10, 23, 天秤座",
		"10, 24, 蠍座",   "11, 22, 蠍座",
		"11, 23, 射手座", "12, 21, 射手座"})
	void testGetConstellation(int month, int day, String expected) {
		assertEquals(expected, util.getConstellation(month, day));
	}
}
