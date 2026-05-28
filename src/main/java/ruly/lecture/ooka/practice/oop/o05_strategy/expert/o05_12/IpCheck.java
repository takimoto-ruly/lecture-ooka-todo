package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_12;

import java.util.List;

public class IpCheck implements SecurityStrategy {
	private static final String BLACK_LIST_IP = "999.999.999.999";

	@Override
	public boolean isSafeIpList(List<String> ipList) {
		boolean hasBlocked = ipList.stream().anyMatch(x -> x.startsWith("BLOCKED_"));
		if (hasBlocked) {
			return false;
		}

		boolean hasBlackListIp = ipList.contains(BLACK_LIST_IP);
		return !hasBlackListIp;
	}
}