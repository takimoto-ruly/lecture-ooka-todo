package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_09;

public class Heating extends HomeAppliances {
	public Heating(String deviceName, int power) {
		super(deviceName, power);
	}

	@Override
	public int powerConsumption(OperatingModeStrategy operatingModeStrategy) {
		return super.powerConsumption(operatingModeStrategy) + 200;
	}
}