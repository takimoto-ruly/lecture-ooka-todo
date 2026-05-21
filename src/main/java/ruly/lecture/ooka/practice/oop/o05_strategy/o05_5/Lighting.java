package ruly.lecture.ooka.practice.oop.o05_strategy.o05_5;

public class Lighting extends HomeAppliances {
	public Lighting(String name, ModeStrategy modeStrategy) {
		super(name, modeStrategy);
	}

	@Override
	public int clculetePowerConsumption() {
		return modeStrategy.PowerConsumption(100);
	}
}