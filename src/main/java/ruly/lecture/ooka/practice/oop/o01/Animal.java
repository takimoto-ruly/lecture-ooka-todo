package ruly.lecture.ooka.practice.oop.o01;

public class Animal {

	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void sleep() {
		System.out.println("[" + this.name + "]は眠っています。");
	}
}
