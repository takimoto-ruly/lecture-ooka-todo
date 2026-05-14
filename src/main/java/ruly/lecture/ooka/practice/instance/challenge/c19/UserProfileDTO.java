package ruly.lecture.ooka.practice.instance.challenge.c19;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class UserProfileDTO {

	private List<BankAccountDTO> accounts = new ArrayList<>();
	private boolean isBlacklisted;

	public UserProfileDTO(List<BankAccountDTO> account, boolean isBlacklisted) {
		this.accounts = account;
		this.isBlacklisted = isBlacklisted;
	}
}
