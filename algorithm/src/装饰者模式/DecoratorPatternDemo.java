package 装饰者模式;
/**
 * 给一个形状(三角或圆)加上红色的border
 * @author yinjialing
 *
 */
public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Shape circle=new Circle();
		Shape redCircle=new RedShapeDecorator(new Circle());
		
		Shape redRectangle=new RedShapeDecorator(new Rectangle());
		System.out.println("normal border");
		circle.draw();
		
		System.out.println("\ncircle of red border");
		redCircle.draw();
		
		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}

}
