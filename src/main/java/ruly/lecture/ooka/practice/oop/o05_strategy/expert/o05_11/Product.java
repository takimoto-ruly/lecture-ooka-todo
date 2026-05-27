package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Product {
	private String goodsName;
	private int amount;
	private InventoryAllocationStrategy inventoryAllocationStrategy;
	private PackagingCostStrategy packagingCostStrategy;

	public boolean canAllocate(int orderQuentity, List<Integer> stocks) {
		return inventoryAllocationStrategy.allocation(orderQuentity, stocks);
	}

	public int calculateTotalShippingCost(String deliveryArea) {
		return this.amount + packagingCostStrategy.calculateCost(amount, deliveryArea);
	}
}