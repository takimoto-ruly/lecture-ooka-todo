package ruly.lecture.ooka.practice.oop.o05_strategy.o05_1;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class Shop {
	private String shopName;
	private PaymentStrategy paymentStrategy;

	public String processPayment(int amount) {
		return paymentStrategy.pay(amount);
	}
}