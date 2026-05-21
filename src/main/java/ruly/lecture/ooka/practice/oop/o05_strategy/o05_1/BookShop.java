package ruly.lecture.ooka.practice.oop.o05_strategy.o05_1;

public class BookShop extends Shop {
	public BookShop(String shopName, PaymentStrategy paymentMethod) {
		super(shopName, paymentMethod);
	}

	public void preview() {
		System.out.println("試し読みしました");
	}
}
