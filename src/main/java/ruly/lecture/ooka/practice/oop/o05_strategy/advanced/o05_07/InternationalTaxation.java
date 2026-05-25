package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_07;

public class InternationalTaxation implements TaxationStrategy {

	@Override
	public int calculateTax(int amount) {
		if (amount <= 100000) {
			return 0;
		}

		return (int) (amount * 0.1);
	}
}