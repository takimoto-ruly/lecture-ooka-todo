package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_09;

import lombok.Setter;

public class FloorHeating extends Heating {
	@Setter
	private boolean isRunning;

	public FloorHeating(String deviceName, int power) {
		super(deviceName, power);
	}

	@Override
	public int powerConsumption(OperatingModeStrategy operatingModeStrategy) {
		if (this.isRunning) {
			return super.powerConsumption(operatingModeStrategy) + 500;
		}
		return super.powerConsumption(operatingModeStrategy);
	}
}