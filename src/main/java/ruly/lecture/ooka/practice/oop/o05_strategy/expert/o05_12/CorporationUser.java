package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_12;

import java.util.List;

import lombok.Setter;

public class CorporationUser extends PlemiumUser {
	@Setter
	private int contractCount;

	public CorporationUser(String userId, int currencyAmount, String currencyCode, List<String> ipList,
			CurrencyExchangeStrategy currencyExchangeStrategy, SecurityStrategy securityStrategy) {
		super(userId, currencyAmount, currencyCode, ipList, currencyExchangeStrategy, securityStrategy);
	}

	@Override
	public int calculatePaymentAmount() {
		return super.calculatePaymentAmount() * contractCount;
	}
}