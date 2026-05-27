package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

public class PrecisionProduct extends Product {
	public PrecisionProduct(String goodsName, int amount,
			InventoryAllocationStrategy inventoryAllocationStrategy, PackagingCostStrategy packagingCostStrategy) {
		super(goodsName, amount, inventoryAllocationStrategy, packagingCostStrategy);
	}

	@Override
	public int totalShippingCost(int amount, String deliveryArea) {
		return super.totalShippingCost(amount, deliveryArea) + 1500;
	}
}