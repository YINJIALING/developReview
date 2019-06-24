package 设计模式.模版方法模式;
class Fish extends Template{

	@Override
	void kill() {
		System.out.println("杀鱼专用");
		
	}

	@Override
	void inPot() {
		System.out.println("煮鱼专用");
		
	}
	
}
class Lobster extends Template{

	@Override
	void kill() {
		System.out.println("杀小龙虾专用");
		
	}

	@Override
	void inPot() {
		System.out.println("煮小龙虾专用");
		
	}
	
}
abstract class Template{
	abstract void kill();
	
	//给定一个默认的实现，大部分情况下使用这个默认的实现即可，必要的话子类可以重写
	public void clean() {
		System.out.println("洗干净 ");
	}
	abstract void inPot();
	 void fire() {
		System.out.println("开火煮 ");
	}
	 //核心：执行定义的流程/
	//为了防止这个流程被子类修改，使用final方法修饰，确保所有的子类都是按这个流程走
	public final void cooking() {
		kill();
		clean();
		inPot();
		fire();
	}
}
public class 模版方法模式 {

	public static void main(String[] args) {
		Fish fish=new Fish();
		Lobster lobster=new Lobster();
		fish.cooking();
		System.out.println("------------------");
		lobster.cooking();
	}

}
