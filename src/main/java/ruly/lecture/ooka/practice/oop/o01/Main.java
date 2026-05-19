package ruly.lecture.ooka.practice.oop.o01;

public class Main {
	public static void main(String[] args) {
		Dog dog = new Dog("ポチ");
		System.out.println(dog.getName());
		dog.sleep();
		dog.bark();
	}
}
