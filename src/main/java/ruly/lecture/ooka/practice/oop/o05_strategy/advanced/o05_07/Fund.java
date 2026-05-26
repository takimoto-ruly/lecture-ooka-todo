package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_07;

public class Fund extends FinancialAsset {
	public Fund(String assetsName, int operationProfit) {
		super(assetsName, operationProfit);
	}

	@Override
	public int calculateProfit(TaxationStrategy taxationStrategy) {
		return super.calculateProfit(taxationStrategy) - 500;
	}
}