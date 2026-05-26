package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_08;

public class SacrificeFightingStyle implements FightingStyleStrategy {
	@Override
	public int calculateAttackPower(int attackPower) {
		return (int) (attackPower * 2.5);
	}
}