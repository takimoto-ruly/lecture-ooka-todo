package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("メッセージング・パイプラインの網羅テスト")
class MessagePipelineTest {

	@Test
	@DisplayName("正常系：大文字変換/サニタイズ戦略適用時の、親・子・孫による文字列パイプライン加工の検証")
	void testMessageProcessingPipeline() {
		DataProcessingStrategy upper = new ConvertToUppercase();
		DataProcessingStrategy sanitize = new ConvertSanitize();

		String rawText = "Hello html World";

		// 1. 親クラス（加工結果をそのまま戻す）
		StreamRequest parent = new StreamRequest(rawText);
		assertEquals("HELLO HTML WORLD", parent.getMaintext(upper));
		assertEquals("Hello text World", parent.getMaintext(sanitize));

		// 2. 子クラス（先頭に識別子を付与）
		StreamRequest child = new SecureRequest(rawText);
		assertEquals("[SECURE_CHANNEL] HELLO HTML WORLD", child.getMaintext(upper));

		// 3. 孫クラス（先頭に識別子 + 末尾に電子署名を結合）
		StreamRequest grandchild = new EncryptionRequest(rawText);
		String expected = "[SECURE_CHANNEL] HELLO HTML WORLD_SIGNED_VERIFIED";
		assertEquals(expected, grandchild.getMaintext(upper));
	}

	@Test
	@DisplayName("異常系：コンストラクタおよびStrategyの引数にnullや不正な値が渡された場合の拒否検証")
	void test防衛バリデーション() {
		DataProcessingStrategy upper = new ConvertToUppercase();

		// 親クラスコンストラクタのnull拒否検証
		assertThrows(IllegalArgumentException.class, () -> new StreamRequest(null));
		assertThrows(IllegalArgumentException.class, () -> new StreamRequest(""));

		// Strategy単体のnull拒否検証
		assertThrows(IllegalArgumentException.class, () -> upper.textProcessing(null));
	}
}