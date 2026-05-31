package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_13;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LowHpTargetStrategy implements TargetSelectionStrategy {

	@Override
	public int selectTarget(List<Integer> hpList) {
		List<Integer> aliveIndices = IntStream.range(0, hpList.size())
				.filter(i -> hpList.get(i) > 0)
				.boxed()
				.collect(Collectors.toList());
		return aliveIndices.stream().min(Comparator.comparingInt(hpList::get))
				.orElse(-1);
	}
}