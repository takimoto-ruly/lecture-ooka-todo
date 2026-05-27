package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

import java.util.List;

public class SingleAllocation implements InventoryAllocationStrategy {
	@Override
	public boolean allocation(int orderQuantity, List<Integer> stocks) {
		return stocks.stream().anyMatch(x -> x >= orderQuantity);
	}
}