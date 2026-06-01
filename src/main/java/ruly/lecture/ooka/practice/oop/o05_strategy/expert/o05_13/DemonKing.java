package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_13;

import java.util.List;

public class DemonKing extends MagicMonster {
	public DemonKing(String name, int attackPower, String attribute, TargetSelectionStrategy targetSelectionStrategy,
			EnvironmentStrategy environmentModifierStrategy) {
		super(name, attackPower, attribute, targetSelectionStrategy, environmentModifierStrategy);
	}

	@Override
	public String generateBattleLog(List<Integer> hpList, String weather) {
		int damage = calculateFinalDamage(hpList, weather) * 3;
		int target = getTargetSelectionStrategy().selectTarget(hpList);

		return "【絶望】" + super.getName() + "の攻撃: " + target + "番目に" + damage + "のダメージ！（魔法障壁を展開）";
	}
}