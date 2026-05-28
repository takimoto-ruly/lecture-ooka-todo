package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題2: 国際サブスク決済・多階層システムの網羅テスト")
class SubscriptionBillingTest {

	@Test
	@DisplayName("正常系：USD（150倍）における親・子・孫クラスの多態的決済額およびライセンス乗算の検証")
	void testBillingPipelineWithUsd() {
		CurrencyExchangeStrategy exchange = new CurrencyExchange();
		SecurityStrategy security = new IpCheck();
		List<String> safeIps = Arrays.asList("192.168.0.1", "10.0.0.1");

		// 【USDの検証】100.0 USD ➔ 15000円
		// 親（一般アカウント）: 15000
		UserAccount parent = new UserAccount("ACC01", 100, "USD", safeIps, exchange, security);
		assertEquals(15000, parent.calculatePaymentAmount());

		// 子（プレミアム）: 15000 - 10% = 13500
		UserAccount child = new PlemiumUser("ACC02", 100, "USD", safeIps, exchange, security);
		assertEquals(13500, child.calculatePaymentAmount());

		// 孫（法人マルチ：3ライセンス）: 子13500 * 3 = 40500
		UserAccount grandchild = new CorporationUser("ACC03", 100, "USD", safeIps, exchange, security, 3);
		assertEquals(40500, grandchild.calculatePaymentAmount());
	}

	@Test
	@DisplayName("正常系：EUR（160倍）における親・子・孫クラスの多態的決済額の検証（Strategyの網羅）")
	void testBillingPipelineWithEur() {
		CurrencyExchangeStrategy exchange = new CurrencyExchange();
		SecurityStrategy security = new IpCheck();
		List<String> safeIps = Arrays.asList("192.168.0.1", "10.0.0.1");

		// 【EURの検証】50.0 EUR ➔ 50.0 * 160 = 8000円
		// 親（一般アカウント）: 8000
		UserAccount parent = new UserAccount("ACC04", 50, "EUR", safeIps, exchange, security);
		assertEquals(8000, parent.calculatePaymentAmount());

		// 子（プレミアム）: 8000 - 10% = 7200
		UserAccount child = new PlemiumUser("ACC05", 50, "EUR", safeIps, exchange, security);
		assertEquals(7200, child.calculatePaymentAmount());

		// 孫（法人マルチ：2ライセンス）: 子7200 * 2 = 14400
		UserAccount grandchild = new CorporationUser("ACC06", 50.0, "EUR", safeIps, exchange, security, 2);
		assertEquals(14400, grandchild.calculatePaymentAmount());
	}

	@Test
	@DisplayName("異常系：為替Strategy単体におけるサポート外通貨およびセキュリティの網羅テスト")
	void testInvalidInputsAndSecurity() {
		CurrencyExchangeStrategy exchange = new CurrencyExchange();
		SecurityStrategy security = new IpCheck();

		List<String> safeIps = Arrays.asList("192.168.0.1");
		List<String> unsafePrefixIps = Arrays.asList("BLOCKED_IP_XYZ");
		List<String> blacklistIps = Arrays.asList("999.999.999.999");

		// 1. セキュリティStrategyの分岐網羅
		assertTrue(security.isSafeIpList(safeIps));
		assertFalse(security.isSafeIpList(unsafePrefixIps), "BLOCKED_から始まる場合は不安全");
		assertFalse(security.isSafeIpList(blacklistIps), "ブラックリストIP(999.999.999.999)は不安全");

		// 2. 為替Strategyのサポート外通貨（例外スロー）の網羅
		assertThrows(IllegalArgumentException.class, () -> exchange.currencyExchange(10.0, "GBP"), "GBPはサポート外のため例外");
		assertThrows(IllegalArgumentException.class, () -> exchange.currencyExchange(10.0, "JPY"), "JPYはサポート外のため例外");
		assertThrows(IllegalArgumentException.class, () -> exchange.currencyExchange(10.0, null), "nullは例外");
	}

	@Test
	@DisplayName("異常系：決済処理全体のライフサイクルにおいて、不正IPが含まれる場合に処理が拒否されるかの検証")
	void testSecurityExceptionOnBillingLifecycle() {
		CurrencyExchangeStrategy currency = new CurrencyExchange();
		SecurityStrategy security = new IpCheck();
		List<String> unsafeIps = Arrays.asList("192.168.1.1", "999.999.999.999");

		// 危険なIPが含まれるコンテキストでの決済要求は、為替計算に進む前に拒否されるべき
		UserAccount account = new UserAccount("ACC07", 50, "USD", unsafeIps, currency, security);
		assertThrows(RuntimeException.class, account::calculatePaymentAmount, "危険なIPが含まれる場合は決済処理を実行してはいけません");
	}
}