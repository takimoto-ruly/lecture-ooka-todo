package ruly.lecture.ooka.practice.oop.o05_strategy.o05_4;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Account {
	private String accountName;

	@Setter
	protected FilterStrategy filterStrategy;

	public String mainText(String text) {
		return filterStrategy.filterText(text);
	}
}