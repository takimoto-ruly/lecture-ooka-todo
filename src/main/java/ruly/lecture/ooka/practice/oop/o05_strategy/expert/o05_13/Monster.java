package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_13;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Monster {
	@Getter
	private String name;
	private int attackPower;
	private String attribute;

	private TargetSelectionStrategy targetSelectionStrategy;
	private EnvironmentStrategy environmentModifierStrategy;

	public String generateBattleLog(List<Integer> hpList, String weather) {
		return this.name + "の攻撃: " + targetSelectionStrategy.selectTarget(hpList) + "番目に"
				+ this.calculateFinalDamage(hpList, weather) + "のダメージ！";
	}

	protected int calculateFinalDamage(List<Integer> hpList, String weather) {
		return (int) (attackPower * environmentModifierStrategy.getSynegyCorrector(attribute, weather));
	}

	protected TargetSelectionStrategy getTargetSelectionStrategy() {
		return this.targetSelectionStrategy;
	}
}