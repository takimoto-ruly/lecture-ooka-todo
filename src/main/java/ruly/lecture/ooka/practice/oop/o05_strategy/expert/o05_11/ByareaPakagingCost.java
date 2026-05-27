package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

public class ByareaPakagingCost implements PackagingCostStrategy {
	@Override
	public int calculateCost(int goodsAmount, String DeliveryArea) {
		if (goodsAmount < 0) {
			throw new IllegalArgumentException();
		}

		if (goodsAmount >= 50000) {
			return 0;
		}

		if (DeliveryArea.equals("離島")) {
			return 3000;
		} else {
			return 500;
		}
	}
}