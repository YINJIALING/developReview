package 设计模式.策略模式;
/**
 * 生成销售员实例，告诉销售员节日，使得生成相应的促销方法(使用了简单工厂模式)
 * @author yinjialing
 *
 */
public class Context_SalesMan {
	private Strategy strategy;

	public Context_SalesMan(String festival) {
		switch(festival) {
		//春节就采用春节的促销活动
		case "A":
			strategy=new StrategyA();
			break;
		case "B":
			strategy=new StrategyB();
			break;
		case "C":
			strategy=new StrategyC();
			break;
		}
	}
	
	//向客户展示促销方法
	public void SalesManshow() {
		strategy.show();
	}

}
