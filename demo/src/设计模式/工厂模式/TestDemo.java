package 设计模式.工厂模式;

public class TestDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory=new ShapeFactory();
		Shape shape1=shapeFactory.getShape("circle");
		shape1.draw();
	}

}
