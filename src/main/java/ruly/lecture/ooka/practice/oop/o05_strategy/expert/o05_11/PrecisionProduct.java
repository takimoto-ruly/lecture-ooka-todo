package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

public class PrecisionProduct extends Product {
	public PrecisionProduct(String goodsName, int amount,
			InventoryAllocationStrategy inventoryAllocationStrategy, PackagingCostStrategy packagingCostStrategy) {
		super(goodsName, amount, inventoryAllocationStrategy, packagingCostStrategy);
	}

	@Override
	public int calculateTotalShippingCost(String deliveryArea) {
		return super.calculateTotalShippingCost(deliveryArea) + 1500;
	}
}