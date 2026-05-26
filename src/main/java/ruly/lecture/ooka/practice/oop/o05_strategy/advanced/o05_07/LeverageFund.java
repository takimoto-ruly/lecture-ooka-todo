package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_07;

public class LeverageFund extends Fund {
	public LeverageFund(String assetsName, int operationProfit, int leverage) {
		super(assetsName, operationProfit * leverage);
	}

	@Override
	public int calculateProfit(TaxationStrategy taxationStrategy) {
		return super.calculateProfit(taxationStrategy);
	}
}