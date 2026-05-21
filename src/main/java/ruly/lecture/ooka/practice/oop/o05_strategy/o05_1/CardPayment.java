package ruly.lecture.ooka.practice.oop.o05_strategy.o05_1;

public class CardPayment implements PaymentStrategy {
	@Override
	public String pay(int amount) {
		return amount + "円をカードで支払いました（手数料0円）";
	}
}
