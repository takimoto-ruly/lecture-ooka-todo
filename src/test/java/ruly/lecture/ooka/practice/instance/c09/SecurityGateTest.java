package ruly.lecture.ooka.practice.instance.c09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SecurityGateTest {
	private final SecurityGate gate = new SecurityGate();

	@ParameterizedTest
	@DisplayName("入室判定：権限レベルの境界値・同値クラス")
	@CsvSource({
			"2, 3, false", // レベル不足
			"3, 3, true", // レベル一致（境界値）
			"4, 3, true" // レベル超過（有効）
	})
	void testCanEnter_Level(int userLvl, int roomLvl, boolean expected) {
		UserCard card = new UserCard("User", userLvl, false);
		Room room = new Room("Room", roomLvl);
		assertEquals(expected, gate.canEnter(card, room));
	}

	@Test
	@DisplayName("異常系：有効期限切れやnull入力")
	void testCanEnter_Abnormal() {
		// 期限切れ（レベルが足りていても不可）
		assertFalse(gate.canEnter(new UserCard("User", 5, true), new Room("Room", 1)));
		// nullチェック
		assertFalse(gate.canEnter(null, new Room("Room", 1)));
		assertFalse(gate.canEnter(new UserCard("User", 5, false), null));
	}
}
