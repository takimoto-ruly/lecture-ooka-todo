package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

import lombok.Setter;

@Setter
public class Account {
	private String accountname;
	protected Filter filter;

	public String mainText(String text) {
		return filter.filterText(text);
	}
}