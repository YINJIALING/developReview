package 设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

interface Subject{
	void addObsever(Observer o);
	void removeObsever(Observer o);
	void notifyAllObservers();
}
interface Observer{
	void update(int i);
	//当subject调用notifyAllObservers,会调用这个方法
}
class MySubject implements Subject{
	//用 list存所有的observer
	List<Observer> observers=new ArrayList<>();
	
	private int i;

	@Override
	public void addObsever(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObsever(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyAllObservers() {
		for(Observer o:observers)
			o.update(i);
		
	}
	
	public void doSomething() {
		System.out.println("我做了一些不好的事");
		i=10;
		notifyAllObservers();
	}
}
class Observer1 implements Observer{
	public void update(int i) {
		System.out.println("o1获得变化:"+i);
	}
}
class Observer2 implements Observer{
	public void update(int i) {
		System.out.println("o2获得变化:"+(i*i));
	}
}
public class 观察者模式 {

	public static void main(String[] args) {
		Observer1 o1=new Observer1();
		Observer2 o2=new Observer2();
		MySubject s=new MySubject();
		s.addObsever(o1);
		s.addObsever(o2);
		s.doSomething();
	}

}
