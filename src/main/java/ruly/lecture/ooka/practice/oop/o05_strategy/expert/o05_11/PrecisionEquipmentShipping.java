package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

public class PrecisionEquipmentShipping extends ShippingServise {
	public PrecisionEquipmentShipping(String goodsName, int amount,
			InventoryAllocationStrategy inventoryAllocationStrategy, PackagingCostStrategy packagingCostStrategy) {
		super(goodsName, amount, inventoryAllocationStrategy, packagingCostStrategy);
	}

	@Override
	public int totalShippingCost(int amount, String DeliveryArea) {
		return super.totalShippingCost(amount, DeliveryArea) + 1500;
	}
}