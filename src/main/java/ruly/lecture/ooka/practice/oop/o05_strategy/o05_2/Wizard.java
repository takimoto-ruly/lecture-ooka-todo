package ruly.lecture.ooka.practice.oop.o05_strategy.o05_2;

public class Wizard extends Character {
	public Wizard(String name, ElementalStrategy elementalStrategy) {
		super(name, elementalStrategy);
	}

	@Override
	public int attack() {
		return elementalStrategy.damage(60);
	}
}