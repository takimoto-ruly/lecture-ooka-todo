package ruly.lecture.ooka.practice.oop.o05_strategy.o05_5;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public abstract class HomeAppliances {
	private String name;
	protected ModeStrategy modeStrategy;

	public abstract int clculetePowerConsumption();
}