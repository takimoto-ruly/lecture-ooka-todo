package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShippingServise {
	private String goodsName;
	private int amount;
	private InventoryAllocationStrategy InventoryAllocationStrategy;
	private PackagingCostStrategy packagingCostStrategy;

	public boolean allocationIsSuccess(int orderQuentity, List<Integer> stock) {
		return InventoryAllocationStrategy.allocation(orderQuentity, stock);
	}

	public int totalShippingCost(int amount, String DeliveryArea) {
		return amount + packagingCostStrategy.calculateCost(amount, DeliveryArea);
	}
}