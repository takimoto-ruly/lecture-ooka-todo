package ruly.lecture.ooka.practice.oop.o05_strategy.o05_5;

public class LowPowerMode implements ModeStrategy {
	@Override
	public int PowerConsumption(int power) {
		return (int) (power % 0.5);
	}
}