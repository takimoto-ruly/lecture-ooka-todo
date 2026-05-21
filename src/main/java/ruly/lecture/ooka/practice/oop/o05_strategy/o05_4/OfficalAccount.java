package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

public class OfficalAccount extends Account {
	public String post(String text) {
		return "公式" + super.mainText(text);
	}
}