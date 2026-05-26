package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_07;

public class FinancialAsset {
	private String assetName;
	private int operationProfit;

	public FinancialAsset(String assetName, int operationProfit) {
		if (operationProfit < 0) {
			throw new IllegalArgumentException();
		}
		this.assetName = assetName;
		this.operationProfit = operationProfit;
	}

	public int calculateProfit(TaxationStrategy taxationStrategy) {
		return this.operationProfit - taxationStrategy.calculateTax(this.operationProfit);
	}
}