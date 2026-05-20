package ruly.lecture.ooka.practice.oop.o05_strategy.o05_1;

public class CashPayment implements PaymentStrategy {
	@Override
	public String pey(int amount) {
		return "[" + amount + "]円を現金で支払いました";
	}
}
