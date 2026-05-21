package ruly.lecture.ooka.practice.oop.o05_strategy.o05_2;

public class IceErement implements ElementalStrategy {
	@Override
	public int damage(int data) {
		return data;
	}
}