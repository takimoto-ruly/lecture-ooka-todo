package ruly.lecture.ooka.practice.oop.o04_template_method.c04_2;

abstract class CookingRecipe {
	public final void cook() {
		System.out.println("材料を切りました。");
		System.out.println("炒めました。");
		System.out.println(getSpice() + "をして完成です！");
	}

	protected abstract String getSpice();
}
