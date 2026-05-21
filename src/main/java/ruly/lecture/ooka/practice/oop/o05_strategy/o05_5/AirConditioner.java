package ruly.lecture.ooka.practice.oop.o05_strategy.o05_5;

public class AirConditioner extends HomeAppliances {
	public AirConditioner(String name, ModeStrategy modeStrategy) {
		super(name, modeStrategy);
	}

	@Override
	public int clculetePowerConsumption() {
		return modeStrategy.PowerConsumption(1000);
	}
}