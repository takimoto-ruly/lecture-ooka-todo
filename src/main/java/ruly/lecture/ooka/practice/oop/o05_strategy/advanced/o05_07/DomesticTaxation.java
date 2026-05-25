package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_07;

public class DomesticTaxation implements TaxationStrategy {

	@Override
	public int calculateTax(int amount) {
		return (int) (amount * 0.2);
	}
}