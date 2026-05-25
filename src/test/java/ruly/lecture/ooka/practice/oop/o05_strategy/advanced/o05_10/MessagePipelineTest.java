package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題5: メッセージング・パイプラインの網羅テスト")
class MessagePipelineTest {

	@Test
	@DisplayName("正常系：大文字変換/サニタイズ戦略適用時の、親・子・孫による文字列パイプライン加工の検証")
	void testMessageProcessingPipeline() {
		MessageStrategy upper = new UpperCaseStrategy();
		MessageStrategy sanitize = new SanitizeStrategy();

		String rawText = "Hello html World";

		// 1. 親クラス（加工結果をそのまま戻す）
		MessageRequest parent = new MessageRequest(rawText);
		assertEquals("HELLO HTML WORLD", parent.process(upper));
		assertEquals("Hello text World", parent.process(sanitize));

		// 2. 子クラス（先頭に識別子を付与）
		MessageRequest child = new SecureMessageRequest(rawText);
		assertEquals("[SECURE_CHANNEL] HELLO HTML WORLD", child.process(upper));

		// 3. 孫クラス（先頭に識別子 + 末尾に電子署名を結合）
		MessageRequest grandchild = new SignedSecureMessageRequest(rawText);
		String expected = "[SECURE_CHANNEL] HELLO HTML WORLD_SIGNED_VERIFIED";
		assertEquals(expected, grandchild.process(upper));
	}

	@Test
	@DisplayName("異常系：コンストラクタおよびStrategyの引数にnullや不正な値が渡された場合の拒否検証")
	void test防衛バリデーション() {
		MessageStrategy upper = new UpperCaseStrategy();

		// 親クラスコンストラクタのnull拒否検証
		assertThrows(IllegalArgumentException.class, () -> new MessageRequest(null));
		assertThrows(IllegalArgumentException.class, () -> new MessageRequest(""));

		// Strategy単体のnull拒否検証
		assertThrows(IllegalArgumentException.class, () -> upper.convert(null));
	}
}