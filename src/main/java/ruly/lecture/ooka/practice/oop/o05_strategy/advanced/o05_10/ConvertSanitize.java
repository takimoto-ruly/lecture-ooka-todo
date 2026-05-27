package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_10;

public class ConvertSanitize implements DataProcessingStrategy {
	@Override
	public String textProcessing(String text) {
		return text.replace("html", "text");
	}
}