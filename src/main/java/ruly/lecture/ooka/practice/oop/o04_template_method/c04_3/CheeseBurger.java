package ruly.lecture.ooka.practice.oop.o04_template_method.c04_3;

public class CheeseBurger extends HamburgerShop {
	protected String filling() {
		return "具材を乗せます";
	}

	protected String source() {
		return "ソースをかけます";
	}

	public boolean topping() {
		return true;
	}
}
