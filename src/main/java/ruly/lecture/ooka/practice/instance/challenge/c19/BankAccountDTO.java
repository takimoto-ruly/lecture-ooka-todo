package ruly.lecture.ooka.practice.instance.challenge.c19;

import lombok.Getter;

@Getter
public class BankAccountDTO {

	private String bankname;
	private int balance;
	private boolean isFrozen;

	public BankAccountDTO(String bankName, int balance, boolean isFrozen) {
		this.bankname = bankName;
		this.balance = balance;
		this.isFrozen = isFrozen;
	}
}
