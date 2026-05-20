package ruly.lecture.ooka.practice.oop.o04_template_method.c04_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ゲームのターン処理の網羅テスト")
class GameTurnTest {

	@Test
	@DisplayName("戦士のターン：通常計算、および防御力が上回った場合の境界値検証")
	void testWarriorCalculation() {
		Game warrior = new Warrior();

		// 通常パターン (50 - 20 = 30)
		assertEquals(30, warrior.damage(50, 20));

		// 同値パターン (20 - 20 = 0)
		assertEquals(0, warrior.damage(20, 20));

		// 境界値：防御力の方が高い場合（マイナスダメージを考慮しているか、仕様に合わせて検証）
		// ※ここでは仕様通り「そのまま返す（10 - 20 = -10）」としてテストを記述
		assertEquals(-10, warrior.damage(10, 20), "仕様通りの計算式が適用されている必要があります");
	}

	@Test
	@DisplayName("魔法使いのターン：敵の防御力に関わらず、攻撃力がそのままダメージになることの検証")
	void testWizardCalculation() {
		Game wizard = new Wizard();

		// 防御力が低かろうが高かろうが攻撃力がそのまま返る
		assertEquals(50, wizard.damage(50, 20));
		assertEquals(100, wizard.damage(100, 999));
		assertEquals(0, wizard.damage(0, 10));
	}
}
