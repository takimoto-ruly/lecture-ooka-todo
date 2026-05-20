package ruly.lecture.ooka.practice.oop.o05_strategy.o05_1;

public class AppareelShop extends Shop {
	public AppareelShop(String shopName, PaymentStrategy paymentMethod) {
		super(shopName, paymentMethod);
	}

	public void fitting() {
		System.out.println("試着しました");
	}
}
