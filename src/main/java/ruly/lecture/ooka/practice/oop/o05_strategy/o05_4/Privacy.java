package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

public class Privacy implements FilterStrategy {
	@Override
	public String filterText(String tetx) {
		return tetx.replace("秘密", "***");
	}
}