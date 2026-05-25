package ruly.lecture.ooka.practice.oop.o05_strategy.o05_5;

public class NormalMode implements ActionModeStrategy {
	@Override
	public int PowerConsumption(int power) {
		return power;
	}
}