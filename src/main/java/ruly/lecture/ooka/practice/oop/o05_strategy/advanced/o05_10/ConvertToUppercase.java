package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_10;

public class ConvertToUppercase implements DataProcessingStrategy {
	@Override
	public String textProcessing(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		return text.toUpperCase();
	}
}