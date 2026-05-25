package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("金融マルチレイヤータックスシステムの網羅テスト")
class FinancialTaxSystemTest {

	@Test
	@DisplayName("正常系：親・子・孫クラスにおける税引き後利益と、孫クラスのレバレッジ倍率動的検証")
	void testTaxAndLeverage() {
		TaxationStrategy domestic = new DomesticTaxation();
		TaxationStrategy international = new InternationalTaxation();

		// 1. 親クラス（一般資産：利益 200,000円）
		FinancialAssets asset = new FinancialAssets("一般株式", 200000);
		// 国内課税：200000 - (200000 * 0.2) = 160000
		assertEquals(160000, asset.calculateProfit(domestic));

		// 2. 子クラス（投資信託：信託報酬 -500円）
		FinancialAssets fund = new Fund("日本株投信", 200000);
		// 国内課税：160000 - 500 = 159500
		assertEquals(159500, fund.calculateProfit(domestic));

		// 3. 孫クラス（レバレッジ2倍投信：元々の利益50,000円 ➔ レバレッジで100,000円として計算）
		// 国際優遇課税：100,000円以下は非課税。よって税金0円。
		// 計算フロー：レバレッジ利益 100000 - 税金0 - 信託報酬500 = 99500
		FinancialAssets leveragedFund = new LeverageFund("米国株レバ2倍", 50000, 2);
		assertEquals(99500, leveragedFund.calculateProfit(international));
	}

	@Test
	@DisplayName("異常系：初期利益に負の数が入力された際のバリデーション検証")
	void testNegativeProfitException() {
		assertThrows(IllegalArgumentException.class, () -> new FinancialAssets("不正資産", -100));
	}
}