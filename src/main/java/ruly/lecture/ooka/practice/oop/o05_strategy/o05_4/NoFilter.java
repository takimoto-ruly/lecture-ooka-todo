package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

public class NoFilter implements FilterStrategy {
	@Override
	public String filterText(String text) {
		return text;
	}
}