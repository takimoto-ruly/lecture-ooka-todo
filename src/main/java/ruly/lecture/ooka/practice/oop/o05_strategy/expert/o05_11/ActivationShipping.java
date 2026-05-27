package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

public class ActivationShipping extends PrecisionEquipmentShipping {
	public ActivationShipping(String goodsName, int amount,
			InventoryAllocationStrategy inventoryAllocationStrategy, PackagingCostStrategy packagingCostStrategy) {
		super(goodsName, amount, inventoryAllocationStrategy, packagingCostStrategy);
	}

	@Override
	public int totalShippingCost(int amount, String DeliveryArea) {
		return super.totalShippingCost(amount, DeliveryArea) + 800;
	}
}