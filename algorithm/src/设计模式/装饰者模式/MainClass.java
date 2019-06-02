package 设计模式.装饰者模式;
/*
 * https://www.runoob.com/design-pattern/decorator-pattern.html
 * https://leonandjava.iteye.com/blog/317823
 */
public class MainClass {

	public static void main(String[] args) {
		// 构建一个正常的rectangle
		Shape rectangle=new Rectangle();
		// 用装饰者模式构建一个红的rectangle
		ShapeDecorator redRectangle=new RedShapeDecorator(rectangle);
		rectangle.draw();
		redRectangle.draw();
	}
}
//component,组件和装饰的公共父类，定义了子类必须实现的方法
interface Shape{
	void draw();
}
//concreteComponent一个具体的实现类，给它增加装饰来增加新功能，被装饰者
class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle");
		
	}
	
}
//装饰者Decorator， 所有装饰的公共父类，定义所有装饰必须实现的方法，并保存了一个对component的引用，可以将用户的请求发送给component，也可以增加一些附加的操作
abstract class ShapeDecorator implements Shape{
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}
	public void draw() {
		decoratedShape.draw();
	}
	
}
//装饰者Decorator的具体实现类，可以用来装饰具体的component
class RedShapeDecorator extends ShapeDecorator{
	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	
	@Override
	public void draw() {
		decoratedShape.draw();
		setRed(decoratedShape);
		
	}
	
	private void setRed(Shape decoratedShape) {
		System.out.println("the shape is red");
	}
	
}
