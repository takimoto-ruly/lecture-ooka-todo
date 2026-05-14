package ruly.lecture.ooka.practice.instance.challenge.c19;

public class FinancialService {

	public boolean canAfford(UserProfileDTO user, PurchaseRequestDTO request) {
		if (user == null || request == null || user.getAccounts() == null) {
			return false;
		}

		if (user.isBlacklisted()) {
			return false;
		}

		int totalBalance = user.getAccounts().stream()
				.filter(BankAccountDTO::isNotFrozen)
				.mapToInt(BankAccountDTO::getBalance)
				.sum();

		if (totalBalance >= request.getPrice()) {
			return true;
		}

		return false;
	}
}
