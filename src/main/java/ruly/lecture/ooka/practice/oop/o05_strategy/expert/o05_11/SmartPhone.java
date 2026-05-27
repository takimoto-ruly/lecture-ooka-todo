package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

public class SmartPhone extends PrecisionProduct {
	public SmartPhone(String goodsName, int amount,
			InventoryAllocationStrategy inventoryAllocationStrategy, PackagingCostStrategy packagingCostStrategy) {
		super(goodsName, amount, inventoryAllocationStrategy, packagingCostStrategy);
	}

	@Override
	public int calculateTotalShippingCost(String deliveryArea) {
		return super.calculateTotalShippingCost(deliveryArea) + 800;
	}
}