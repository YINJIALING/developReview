package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloProxy implements InvocationHandler{
	
	private Object subject;
	
	public HelloProxy(Object subject) {
		super();
		this.subject = subject;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before invoke"+method.getName());
		method.invoke(subject, args);
        System.out.println("After invoke"+method.getName());
		return null;
	}

}
