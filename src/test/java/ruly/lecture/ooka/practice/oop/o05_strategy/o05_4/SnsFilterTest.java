package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SNSフィルターシステムの包括テスト")
class SnsFilterTest {

	@Test
	@DisplayName("Strategyパターン：フィルターの切り替えによる文字列置換の網羅検証")
	void testFilterStrategy() {
		Account user = new GeneralUser("tanaka", new NoFilter());

		// 1. フィルターなし
		assertEquals("[一般] これは秘密です", user.mainText("これは秘密です"));

		// 2. プライバシーフィルター（秘密 -> ***）
		user.setFilterStrategy(new Privacy());
		assertEquals("[一般] これは***です", user.mainText("これは秘密です"));
	}

	@Test
	@DisplayName("多態性：アカウントの種類（一般/公式）による接頭辞の出力検証")
	void testAccountPolymorphism() {
		Privacy filter = new Privacy();
		Account user = new GeneralUser("sato", filter);
		Account official = new OfficalAccount("corp", filter);

		assertEquals("[一般] ***の案件", user.mainText("秘密の案件"));
		assertEquals("【公式】***の案件", official.mainText("秘密の案件"));
	}
}