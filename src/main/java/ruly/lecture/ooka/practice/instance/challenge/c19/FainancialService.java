package ruly.lecture.ooka.practice.instance.challenge.c19;

public class FainancialService {

	public boolean canAfford(UserProfileDTO user, PurchaseRequestDTO request) {
		if (user == null || request == null || user.getAccounts() == null) {
			return false;
		}

		if (user.isBlacklisted()) {
			return false;
		}

		int totalBalance = 0;
		for (BankAccountDTO accounts : user.getAccounts()) {
			if (!accounts.isFrozen()) {
				totalBalance += accounts.getBalance();
			}
		}
		if (totalBalance >= request.getPrice()) {
			return true;
		}

		return false;
	}
}
