package ruly.lecture.ooka.practice.oop.o05_strategy.o05_5;

public class AirConditioner extends HomeAppliance {
	public AirConditioner(String name, ActionModeStrategy modeStrategy) {
		super(name, modeStrategy);
	}

	@Override
	public int calculatePowerConsumption() {
		return actionModeStrategy.PowerConsumption(1000);
	}
}