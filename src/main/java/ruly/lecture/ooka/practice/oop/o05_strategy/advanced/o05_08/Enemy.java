package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_08;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Enemy {
	private String name;
	private int attackPower;

	public String attack(FightingStyleStrategy fightingStyleStrategy) {
		return this.name + " の攻撃：" + fightingStyleStrategy.calculateAttackPower(attackPower) + " ダメージ！";
	}
}