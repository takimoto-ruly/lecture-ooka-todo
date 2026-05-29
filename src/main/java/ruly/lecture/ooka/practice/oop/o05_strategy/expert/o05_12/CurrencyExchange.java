package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_12;

public class CurrencyExchange implements CurrencyExchangeStrategy {
	@Override
	public int currencyExchange(double amount, String currencyCode) {
		if (currencyCode == null) {
			throw new IllegalArgumentException();
		}

		if (!currencyCode.equals("USD") && !currencyCode.equals("EUR")) {
			throw new IllegalArgumentException();
		}

		if (currencyCode.equals("USD")) {
			return (int) (amount * 150);
		}

		if (currencyCode.equals("EUR")) {
			return (int) (amount * 160);
		}

		return 0;
	}
}