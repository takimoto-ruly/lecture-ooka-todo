package ruly.lecture.ooka.practice.oop.o05_strategy.o05_5;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public abstract class HomeAppliance {
	private String name;

	@Setter
	protected ActionModeStrategy actionModeStrategy;

	public abstract int calculatePowerConsumption();
}