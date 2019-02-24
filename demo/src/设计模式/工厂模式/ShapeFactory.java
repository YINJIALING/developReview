package 设计模式.工厂模式;
/**
 * 工厂类，生成基于给定信息的实体类的对象
 * @author yinjialing
 *
 */
public class ShapeFactory {
public Shape getShape(String type) {
	if(type==null)
		return null;
	if(type.equalsIgnoreCase("circle"))
		return new Circle();
	if(type.equalsIgnoreCase("rectangle"))
		return new Rectangle();
	if(type.equalsIgnoreCase("square"))
		return new Square();
	return null;
}
}
