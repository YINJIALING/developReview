package 设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Action{
	void doSomething();
}
//被代理类，要实现接口
class ActionImpl implements Action{

	@Override
	public void doSomething() {
		System.out.println("工作");
		
	}
	
}
//代理类，不用实现接口 
class ActionProxy{
	Action target=null;

	public ActionProxy(Action target) {
		super();
		this.target = target;
	}
	public Action getProxyInstance() {
		return (Action) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("给代理类钱");
				method.invoke(target, args);
				System.out.println("工作完成，撤退");
				return null;
			}
			
		});
	}
}
public class JDK动态代理 {

	public static void main(String[] args) {
		Action action=new ActionImpl();
		Action proxy=new ActionProxy(action).getProxyInstance();
		proxy.doSomething();

	}

}
