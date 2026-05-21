package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

public class NoFilter implements Filter {
	@Override
	public String filterText(String text) {
		return text;
	}
}