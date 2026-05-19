package ruly.lecture.ooka.practice.oop.o04_template_method.c04_3;

abstract class HamburgerShop {
	public void cooking() {
		System.out.println("下のバンズを用意します");
		System.out.println(filling());
		System.out.println(source());
		if (topping()) {
			System.out.println("チーズを追加します");
		}
		System.out.println("上にバンズを乗せて完成！");
	}

	protected abstract String filling();

	protected abstract String source();

	protected boolean topping() {
		return false;
	}
}
