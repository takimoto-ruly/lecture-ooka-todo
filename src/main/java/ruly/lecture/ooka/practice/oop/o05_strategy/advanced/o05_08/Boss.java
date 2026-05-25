package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_08;

public class Boss extends Enemy {
	public Boss(String name, int attackPower) {
		super(name, attackPower);
	}

	@Override
	public String attack(FightingStyleStrategy fightingStyleStrategy) {
		return super.attack(fightingStyleStrategy) + "（周囲にプレッシャーを放っている）";
	}
}