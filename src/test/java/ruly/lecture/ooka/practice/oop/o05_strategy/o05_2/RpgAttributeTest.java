package ruly.lecture.ooka.practice.oop.o05_strategy.o05_2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RPG属性攻撃システムの包括テスト")
class RpgAttributeTest {

	@Test
	@DisplayName("Strategyパターン：属性変更によるダメージ倍率計算の検証")
	void testDamageStrategy() {
		Warrior warrior = new Warrior("アルス", new IceErement());
		// 氷属性：基本40の1.0倍
		assertEquals(40, warrior.attack());

		// 炎属性に切り替え：基本40の1.5倍 = 60
		warrior.setElementalStrategy(new FireElement());
		assertEquals(60, warrior.attack());
	}

	@Test
	@DisplayName("多態性：親の型のリストに混在させ、属性を一括適用して攻撃できるか")
	void testPolymorphicBulkAttack() {
		// 全員一括で炎属性にしてパーティを結成
		ElementalStrategy fire = new FireElement();
		List<Character> party = Arrays.asList(
				new Warrior("ライアン", fire), // 基本40 * 1.5 = 60
				new Wizard("ブライ", fire) // 基本60 * 1.5 = 90
		);

		assertAll("パーティの一斉攻撃検証",
				() -> assertEquals(60, (party.get(0)).attack()),
				() -> assertEquals(90, (party.get(1)).attack()));
	}
}
