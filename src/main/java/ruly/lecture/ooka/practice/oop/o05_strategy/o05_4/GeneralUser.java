package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

public class GeneralUser extends Account {
	public GeneralUser(String accountName, FilterStrategy filterStrategy) {
		super(accountName, filterStrategy);
	}

	@Override
	public String mainText(String text) {
		return "[一般] " + super.mainText(text);
	}
}