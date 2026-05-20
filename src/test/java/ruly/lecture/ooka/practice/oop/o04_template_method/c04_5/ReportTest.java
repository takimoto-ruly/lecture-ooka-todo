package ruly.lecture.ooka.practice.oop.o04_template_method.c04_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題5: レポート出力の網羅テスト")
class ReportTest {

	@Test
	@DisplayName("社内用レポート：全パーツの完全一致検証とNotNullチェック")
	void testInternalReport() {
		Report report = new InternalReport();
		String result = report.generateReport();

		assertNotNull(result, "生成されたレポートがnullになってはいけません");

		String expected = "【社内親睦会】\n--- 2026年度 中間報告 ---\n以上（回覧してください）";
		assertEquals(expected, result, "社内用レポートの構造または文字が一致しません");

		// 改行で区切った際の行数検証（3行構成であること）
		assertEquals(3, result.split("\n").length, "レポートは3行で構成される必要があります");
	}

	@Test
	@DisplayName("提出用レポート：全パーツの完全一致検証と共通本文の含有チェック")
	void testOfficialReport() {
		Report report = new SubmitReport();
		String result = report.generateReport();

		assertNotNull(result);

		String expected = "【株式会社〇〇 御中】\n--- 2026年度 中間報告 ---\nご査収のほどよろしくお願い申し上げます。";
		assertEquals(expected, result, "提出用レポートの構造または文字が一致しません");

		// 共通の本文が確実に含まれているかの検証
		assertTrue(result.contains("--- 2026年度 中間報告 ---"), "共通の本文メッセージが含まれていません");
	}
}
