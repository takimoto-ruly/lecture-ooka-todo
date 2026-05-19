package ruly.lecture.ooka.practice.oop.o02;

public class Main {
	public static void main(String[] args) {
		Shape shapes = new Shape();
		Circle circle = new Circle();
		Square square = new Square();

		System.out.println(shapes.draw());
		System.out.println(circle.draw());
		System.out.println(square.draw());
	}
}
