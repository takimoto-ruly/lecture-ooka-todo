package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_13;

import java.util.List;

public class MagicMonster extends Monster {
	public MagicMonster(String name, int attackPower, String attribute, TargetSelectionStrategy targetSelectionStrategy,
			EnvironmentModifierStrategy environmentModifierStrategy) {
		super(name, attackPower, attribute, targetSelectionStrategy, environmentModifierStrategy);
	}

	@Override
	public String generateBattleLog(List<Integer> hpList, String weather) {
		return super.generateBattleLog(hpList, weather) + "「魔法障壁を展開」";
	}
}