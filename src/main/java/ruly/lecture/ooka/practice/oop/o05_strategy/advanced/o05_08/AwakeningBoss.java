package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_08;

public class AwakeningBoss extends Boss {
	public AwakeningBoss(String name, int attackPower) {
		int bossAttackPower = attackPower + 50;
		super(name, bossAttackPower);
	}

	public String attack(FightingStyleStrategy fightingStyleStrategy) {
		return "【覚醒】" + super.attack(fightingStyleStrategy);
	}
}