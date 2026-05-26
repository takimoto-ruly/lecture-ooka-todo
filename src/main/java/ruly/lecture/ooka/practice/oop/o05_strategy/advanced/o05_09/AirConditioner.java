package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_09;

public class AirConditioner extends HomeAppliance {
	public AirConditioner(String deviceName, int power) {
		super(deviceName, power);
	}

	@Override
	public int powerConsumption(OperatingModeStrategy operatingModeStrategy) {
		return super.powerConsumption(operatingModeStrategy) + 200;
	}
}