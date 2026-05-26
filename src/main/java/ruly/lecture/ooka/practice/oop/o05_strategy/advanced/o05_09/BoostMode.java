package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_09;

public class BoostMode implements OperatingModeStrategy {
	@Override
	public int calculatePower(int power) {
		return (int) (power * 1.5);
	}
}