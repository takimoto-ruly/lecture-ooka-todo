package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_07;

public class FinancialAssets {
	private String assetsName;
	private int operationProfit;

	public FinancialAssets(String assetsName, int operationProfit) {
		if (operationProfit < 0) {
			throw new IllegalArgumentException();
		}
		this.assetsName = assetsName;
		this.operationProfit = operationProfit;
	}

	public int calculateProfit(TaxationStrategy taxationStrategy) {
		return this.operationProfit - taxationStrategy.calculateTax(this.operationProfit);
	}
}