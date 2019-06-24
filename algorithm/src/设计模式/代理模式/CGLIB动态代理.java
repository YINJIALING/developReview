package 设计模式.代理模式;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
class MyAction{
	void doSomthing() {
		System.out.println("do something");
	}
}
//代理工厂
class ProxyFactory implements MethodInterceptor{
	private Object object;

	public ProxyFactory(Object object) {
		super();
		this.object = object;
	}
	
	public Object getProxyInstance() {
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("before");
		arg1.invoke(object, arg2);
		System.out.println("after");
		return null;
	}
	
}

public class CGLIB动态代理 {

	public static void main(String[] args) {
		MyAction myAction=new MyAction();
		MyAction proxyInstance=(MyAction) new ProxyFactory(myAction).getProxyInstance();
		proxyInstance.doSomthing();
	}

}
