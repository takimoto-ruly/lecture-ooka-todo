package ruly.lecture.ooka.practice.oop.o05_strategy.o05_1;

import lombok.Setter;

@Setter
public class Shop {
	private String shopName;
	private PaymentStrategy paymentMethod;

	public Shop(String name, PaymentStrategy paymentMethod) {
		this.shopName = name;
		this.paymentMethod = paymentMethod;
	}

	public String processPayment(int amount) {
		return "[" + this.shopName + "]" + paymentMethod.pey(amount);
	}
}
