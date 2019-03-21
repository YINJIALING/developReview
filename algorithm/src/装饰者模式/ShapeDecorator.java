package 装饰者模式;
/**
 * 实现了shape接口的抽象装饰类
 * @author yinjialing
 *
 */
public abstract class ShapeDecorator implements Shape{
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		super();
		this.decoratedShape = decoratedShape;
	}
	public void draw() {
		decoratedShape.draw();
	}
}
