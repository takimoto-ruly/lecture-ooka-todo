package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

import java.util.List;

public interface InventoryAllocationStrategy {
	public boolean allocation(int orderQuantity, List<Integer> stocks);
}