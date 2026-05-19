package ruly.lecture.ooka.practice.oop.o01;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	public void bark() {
		System.out.println("「ワンワン！」");
	}

	//動作確認
	public static void main(String[] args) {

		Dog dog = new Dog("ポチ");
		System.out.println(dog.getName());
		dog.sleep();
		dog.bark();

	}
}
