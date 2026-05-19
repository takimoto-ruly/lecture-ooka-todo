package ruly.lecture.ooka.practice.oop.o04_template_method.c04_2;

abstract public class Cook {
	public final void srartCooking() {
		System.out.println("材料を斬りました！");
		System.out.println("炒めました！");
		System.out.println(spice() + "をして完成です！");
	}

	protected abstract String spice();
}
