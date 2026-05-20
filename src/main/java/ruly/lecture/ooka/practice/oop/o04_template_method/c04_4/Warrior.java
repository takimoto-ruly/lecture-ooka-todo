package ruly.lecture.ooka.practice.oop.o04_template_method.c04_4;

public class Warrior extends Game {
	protected int damage(int attackPower, int defensePower) {
		return attackPower - defensePower;
	}

}
