package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

public class GeneralUser extends Account {
	public String post(String text) {
		return "一般" + super.mainText(text);
	}
}