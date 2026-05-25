package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

public class OfficalAccount extends Account {
	public OfficalAccount(String accountName, FilterStrategy filterStrategy) {
		super(accountName, filterStrategy);
	}

	@Override
	public String mainText(String text) {
		return "【公式】" + super.mainText(text);
	}
}