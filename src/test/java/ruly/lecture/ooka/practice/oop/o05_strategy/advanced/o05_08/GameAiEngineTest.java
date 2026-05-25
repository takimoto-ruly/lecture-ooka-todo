package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題3: ゲームAI多階層戦闘エンジンの網羅テスト")
class GameAiEngineTest {

	@Test
	@DisplayName("正常系：通常/捨身戦術切り替え時における、親・子・孫の出力文字列の連鎖オーバーライド検証")
	void testBattleOutputChain() {
		BattleTactics normal = new NormalTactics();
		BattleTactics desperate = new DesperateTactics();

		// 1. 親クラス（基本攻撃力 100）
		EnemyBase goblin = new EnemyBase("ゴブリン", 100);
		assertEquals("ゴブリン の攻撃：100 ダメージ！", goblin.generateAttackMessage(normal));

		// 2. 子クラス（エリアボス：末尾にプレッシャー追加）
		EnemyBase dragon = new AreaBossEnemy("ドラゴン", 100);
		assertEquals("ドラゴン の攻撃：100 ダメージ！（周囲にプレッシャーを放っている）", dragon.generateAttackMessage(normal));

		// 3. 孫クラス（覚醒エリアボス：攻撃力+50、先頭に【覚醒】、捨身戦術で (100+50)*2.5 = 375）
		EnemyBase awakenedDragon = new AwakenedAreaBossEnemy("真・ドラゴン", 100);
		String expectedMessage = "【覚醒】真・ドラゴン の攻撃：375 ダメージ！（周囲にプレッシャーを放っている）";
		assertEquals(expectedMessage, awakenedDragon.generateAttackMessage(desperate));
	}
}