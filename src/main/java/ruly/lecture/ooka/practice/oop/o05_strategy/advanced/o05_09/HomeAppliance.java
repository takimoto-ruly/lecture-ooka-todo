package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_09;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HomeAppliance {
	private String deviceName;
	private int power;

	public int powerConsumption(OperatingModeStrategy operatingModeStrategy) {
		return operatingModeStrategy.calculatePower(power);
	}
}