package ruly.lecture.ooka.practice.instance.challenge.c19;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FinancialServiceTest {
	private final FainancialService service = new FainancialService();

	@Test
	@DisplayName("正常系：複数口座の合算で支払える")
	void testCanAfford_SumSuccess() {
		UserProfileDTO user = new UserProfileDTO(Arrays.asList(
				new BankAccountDTO("BankA", 5000, false),
				new BankAccountDTO("BankB", 3000, false)), false);
		PurchaseRequestDTO request = new PurchaseRequestDTO(8000);

		assertTrue(service.canAfford(user, request), "合計8000で8000円の商品は買える");
	}

	@Test
	@DisplayName("同値クラス：凍結口座が除外されること")
	void testCanAfford_FrozenAccount() {
		UserProfileDTO user = new UserProfileDTO(Arrays.asList(
				new BankAccountDTO("BankA", 10000, true), // 凍結
				new BankAccountDTO("BankB", 2000, false) // 有効
		), false);
		PurchaseRequestDTO request = new PurchaseRequestDTO(5000);

		assertFalse(service.canAfford(user, request), "有効なのは2000円だけなのでNG");
	}

	@Test
	@DisplayName("異常系：ブラックリスト")
	void testCanAfford_Blacklist() {
		UserProfileDTO user = new UserProfileDTO(Arrays.asList(
				new BankAccountDTO("BankA", 100000, false)), true); // ブラックリスト
		assertFalse(service.canAfford(user, new PurchaseRequestDTO(100)));
	}
}
