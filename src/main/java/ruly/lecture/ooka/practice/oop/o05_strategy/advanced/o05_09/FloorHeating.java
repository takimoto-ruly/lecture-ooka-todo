package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_09;

public class FloorHeating extends Heating {
	private boolean isRunning;

	public FloorHeating(String deviceName, int power, boolean isRunning) {
		super(deviceName, power);
		this.isRunning = isRunning;
	}

	@Override
	public int powerConsumption(OperatingModeStrategy operatingModeStrategy) {
		if (this.isRunning) {
			return super.powerConsumption(operatingModeStrategy) + 500;
		}
		return super.powerConsumption(operatingModeStrategy);
	}
}