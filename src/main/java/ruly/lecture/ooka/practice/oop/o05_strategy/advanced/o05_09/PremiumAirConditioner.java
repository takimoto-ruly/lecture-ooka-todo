package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_09;

import lombok.Setter;

public class PremiumAirConditioner extends AirConditioner {
	@Setter
	private boolean floorHeaterIsRunning;

	public PremiumAirConditioner(String deviceName, int power) {
		super(deviceName, power);
	}

	@Override
	public int powerConsumption(OperatingModeStrategy operatingModeStrategy) {
		if (this.floorHeaterIsRunning) {
			return super.powerConsumption(operatingModeStrategy) + 500;
		}
		return super.powerConsumption(operatingModeStrategy);
	}
}