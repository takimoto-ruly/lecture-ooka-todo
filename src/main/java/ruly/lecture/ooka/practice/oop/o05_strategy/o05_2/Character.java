package ruly.lecture.ooka.practice.oop.o05_strategy.o05_2;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public abstract class Character {
	private String name;
	protected ElementalStrategy elementalStrategy;
}