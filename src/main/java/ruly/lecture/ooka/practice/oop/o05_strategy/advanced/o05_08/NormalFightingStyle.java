package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_08;

public class NormalFightingStyle implements FightingStyleStrategy {

	@Override
	public int calculateAttockPower(int attackPower) {
		return attackPower;
	}
}