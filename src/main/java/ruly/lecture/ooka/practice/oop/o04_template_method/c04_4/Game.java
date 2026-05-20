package ruly.lecture.ooka.practice.oop.o04_template_method.c04_4;

abstract class Game {
	public void turn(int attackPower, int defensePower) {
		System.out.println("敵に" + damage(attackPower, defensePower) + "の被害を与えた！");
	}

	protected abstract int damage(int attackPower, int defensePower);
}
