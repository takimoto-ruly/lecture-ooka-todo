package ruly.lecture.ooka.practice.instance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class C05_PremiumMemberTest {
	@Test
	@DisplayName("会員情報が正しく初期化され、不変性が保たれていること")
	void testMemberInitialization() {
		C05_PremiumMember member = new C05_PremiumMember("M001", "山田太郎");

		assertEquals("M001", member.getMemberId());
		assertEquals("山田太郎", member.getMemberName());
		assertEquals(0, member.getPoints());
		assertFalse(member.isDiamond(), "初期状態はダイヤモンド会員ではないこと");
	}

	@Test
	@DisplayName("ポイント加算により、10000ポイントで自動的にダイヤモンド会員に昇格すること")
	void testRankUpLogic() {
		C05_PremiumMember member = new C05_PremiumMember("M002", "田中");

		member.addPoints(9999);
		assertFalse(member.isDiamond());

		member.addPoints(1); // 合計10000
		assertTrue(member.isDiamond(), "10000ポイント到達でダイヤモンド会員に昇格する必要があります");

		member.usePoints(5000);
		assertTrue(member.isDiamond(), "ポイントが減ってもダイヤモンド会員は維持される必要があります");
	}

	@Test
	@DisplayName("ポイント消費のバリデーションと、staticな合計ポイントの同期")
	void testPointsAndTotalStat() {
		int startTotal = C05_PremiumMember.getTotalSystemPoints();

		C05_PremiumMember m1 = new C05_PremiumMember("A", "UserA");
		C05_PremiumMember m2 = new C05_PremiumMember("B", "UserB");

		m1.addPoints(5000);
		m2.addPoints(3000);

		m1.usePoints(1000); // 成功
		boolean fail = m2.usePoints(5000); // 失敗（ポイント不足）
		assertFalse(fail);

		// 合計: (5000 - 1000) + 3000 = 7000
		assertEquals(startTotal + 7000, C05_PremiumMember.getTotalSystemPoints(),
				"システム全体の合計ポイントが、個々の増減と正しく連動している必要があります");
	}
}
