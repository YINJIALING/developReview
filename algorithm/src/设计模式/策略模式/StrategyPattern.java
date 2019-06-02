package 设计模式.策略模式;

public class StrategyPattern {

	public static void main(String[] args) {
		Context_SalesMan salesman;
		System.out.print("spring festival:");
		salesman=new Context_SalesMan("A");
		salesman.SalesManshow();
		
		System.out.print("mooncake festival:");
		salesman=new Context_SalesMan("B");
		salesman.SalesManshow();
	
		System.out.print("chrimaster festival:");
		salesman=new Context_SalesMan("C");
		salesman.SalesManshow();
	}

}
