package ruly.lecture.ooka.practice.instance.challenge.c19;

import lombok.Getter;

@Getter
public class PurchaseRequestDTO {

	private int price;

	public PurchaseRequestDTO(int price) {
		this.price = price;
	}
}
