package ruly.lecture.ooka.practice.oop.o03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題3: RPG战斗システム一括処理の網羅テスト")
class RpgSystemTest {

	@Test
	@DisplayName("親クラス型のリストに異なる子クラスを混在させ、ループで一斉に正しい攻撃ができること")
	void testBulkPolymorphicAttack() {
		// 親クラス（Character）のリストに、戦士・魔法使い・一般キャラを混在させる
		List<Character> party = Arrays.asList(
				new Warrior(),
				new Wizard(),
				new Character());

		// 各キャラクターの攻撃内容が、リストのループ（インデックス指定等）でも正しく呼び出せるか検証
		assertAll("パーティ全員の個別攻撃検証",
				() -> assertEquals("剣で斬る！", party.get(0).attack(), "1番目の戦士は剣で斬るべきです"),
				() -> assertEquals("魔法を放つ！", party.get(1).attack(), "2番目の魔法使いは魔法を放つべきです"),
				() -> assertEquals("攻撃した！", party.get(2).attack(), "3番目の一般キャラは通常攻撃をすべきです"));
	}

	@Test
	@DisplayName("ヌルチェックおよび空文字の境界値・網羅検証")
	void testAttackMessageValidity() {
		List<Character> party = Arrays.asList(new Warrior(), new Wizard());

		for (Character member : party) {
			String message = member.attack();

			assertNotNull(message, "攻撃メッセージがnullになってはいけません");
			assertFalse(message.trim().isEmpty(), "攻撃メッセージが空文字になってはいけません");
		}
	}
}