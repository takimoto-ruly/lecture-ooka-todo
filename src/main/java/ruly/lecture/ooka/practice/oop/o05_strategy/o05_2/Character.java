package ruly.lecture.ooka.practice.oop.o05_strategy.o05_2;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public abstract class Character {
	private String name;

	@Setter
	protected ElementalStrategy elementalStrategy;

	public abstract int attack();
}