package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題3: RPG戦闘AI・多階層システムの網羅テスト")
class RpgBattleTest {

	@Test
	@DisplayName("正常系：ターゲット選定（生存最小HP走査）、環境倍率、および魔王（孫）の3倍補正＆テキスト連鎖の検証")
	void testBattleAiAndPolymorphism() {
		TargetSelectionStrategy targeting = new LowHpTargetStrategy();
		EnvironmentStrategy environment = new AttributeSynergy();

		// インデックス1番目の「45」がターゲット（0は死亡しているため対象外とするループ）
		List<Integer> partyHps = Arrays.asList(120, 45, 0, 90);

		// 1. ターゲット選択（最小HP走査ループ）の個別検証
		assertEquals(1, targeting.selectTarget(partyHps));

		// 2. 親・子・孫の戦闘メッセージ多態性検証（基本攻撃力50, FIRE属性, SUNNY気候 = 2.0倍 ➔ 100ダメージ）
		// 親（基本エネミー）
		Monster parent = new Monster("ゴブリン", 50, "FIRE", targeting, environment);
		assertEquals("ゴブリンの攻撃: 1番目に100のダメージ！", parent.generateBattleLog(partyHps, "SUNNY"));

		// 子（魔法系：末尾追加）
		Monster child = new MagicMonster("メイジ", 50, "FIRE", targeting, environment);
		assertEquals("メイジの攻撃: 1番目に100のダメージ！（魔法障壁を展開）", child.generateBattleLog(partyHps, "SUNNY"));

		// 孫（魔王：先頭に【絶望】、かつダメージ値を3倍の300に置換）
		Monster grandchild = new DemonKing("魔王デスタ", 50, "FIRE", targeting, environment);
		String expected = "【絶望】魔王デスタの攻撃: 1番目に300のダメージ！（魔法障壁を展開）";
		assertEquals(expected, grandchild.generateBattleLog(partyHps, "SUNNY"));
	}
}