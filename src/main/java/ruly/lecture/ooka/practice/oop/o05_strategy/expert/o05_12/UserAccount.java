package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_12;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserAccount {
	private String userId;
	private int currencyAmount;
	private String currencyCode;
	private List<String> ipList = new ArrayList<>();
	private CurrencyExchangeStrategy currencyExchangeStrategy;
	private SecurityStrategy securityStrategy;

	public int calculatePaymentAmount() {
		if (!securityStrategy.isSafeIpList(ipList)) {
			throw new IllegalArgumentException();
		}

		return currencyExchangeStrategy.currencyExchange(currencyAmount, currencyCode);
	}
}