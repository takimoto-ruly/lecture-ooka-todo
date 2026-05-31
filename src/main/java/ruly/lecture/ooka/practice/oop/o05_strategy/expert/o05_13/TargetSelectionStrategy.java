package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_13;

import java.util.List;

public interface TargetSelectionStrategy {
	int selectTarget(List<Integer> hpList);
}