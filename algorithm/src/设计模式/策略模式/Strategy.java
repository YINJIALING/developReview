package 设计模式.策略模式;
/**
 * 百货公司所有促销的接口
 * @author yinjialing
 * https://www.jianshu.com/p/0c62bf587b9c
 */
public abstract class Strategy {
	public abstract void show();
}
/**
 * 为春节准备的促销
 * @author yinjialing
 *
 */
class StrategyA extends Strategy{

	@Override
	public void show() {
		System.out.println("为春节准备的促销A");
		
	}

}
/**
 * 为中秋节准备的促销
 * @author yinjialing
 *
 */
class StrategyB extends Strategy{

	@Override
	public void show() {
		System.out.println("为中秋节准备的促销B");
		
	}

}
/**
 * 为圣诞准备的促销
 * @author yinjialing
 *
 */
class StrategyC extends Strategy{

	@Override
	public void show() {
		System.out.println("为圣诞准备的促销C");
		
	}

}
