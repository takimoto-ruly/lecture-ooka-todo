package ruly.lecture.ooka.practice.oop.o02;

public class Main {

	public static void main(String[] args) {

		Shapes shapes = new Shapes();
		Circle circle = new Circle();
		Square square = new Square();

		System.out.println(shapes.drawing());
		System.out.println(circle.drawing());
		System.out.println(square.drawing());
	}
}
