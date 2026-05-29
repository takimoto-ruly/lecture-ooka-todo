package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_12;

import java.util.List;

public class CorporationUser extends PlemiumUser {
	private int contractCount;

	public CorporationUser(String userId, double currencyAmount, String currencyCode, List<String> ipList,
			CurrencyExchangeStrategy currencyExchangeStrategy, SecurityStrategy securityStrategy, int contractCount) {
		super(userId, currencyAmount, currencyCode, ipList, currencyExchangeStrategy, securityStrategy);
		this.contractCount = contractCount;
	}

	@Override
	public int calculatePaymentAmount() {
		return super.calculatePaymentAmount() * contractCount;
	}
}