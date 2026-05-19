package ruly.lecture.ooka.practice.oop.o01;

import lombok.Getter;

@Getter
public class Animal {

	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public void sleep() {
		System.out.println("[" + this.name + "]は眠っています。");
	}
}
