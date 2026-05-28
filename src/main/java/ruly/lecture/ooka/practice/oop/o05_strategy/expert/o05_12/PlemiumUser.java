package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_12;

import java.util.List;

public class PlemiumUser extends UserAccount {
	public PlemiumUser(String userId, int currencyAmount, String currencyCode, List<String> ipList,
			CurrencyExchangeStrategy currenctExchangeStrategy, SecurityStrategy securityStrategy) {
		super(userId, currencyAmount, currencyCode, ipList, currenctExchangeStrategy, securityStrategy);
	}

	@Override
	public int calculatePaymentAmount() {
		return (int) (super.calculatePaymentAmount() * 0.9);
	}
}