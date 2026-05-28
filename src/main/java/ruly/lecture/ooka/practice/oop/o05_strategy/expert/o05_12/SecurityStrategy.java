package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_12;

import java.util.List;

public interface SecurityStrategy {
	boolean isSafeIpList(List<String> ipList);
}