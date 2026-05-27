package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

public class SmartPhone extends PrecisionProduct {
	public SmartPhone(String goodsName, int amount,
			InventoryAllocationStrategy inventoryAllocationStrategy, PackagingCostStrategy packagingCostStrategy) {
		super(goodsName, amount, inventoryAllocationStrategy, packagingCostStrategy);
	}

	@Override
	public int totalShippingCost(int amount, String deliveryArea) {
		return super.totalShippingCost(amount, deliveryArea) + 800;
	}
}