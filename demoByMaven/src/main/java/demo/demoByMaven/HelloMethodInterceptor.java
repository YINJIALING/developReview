package demo.demoByMaven;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class HelloMethodInterceptor implements MethodInterceptor{
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("Before"+arg1.getName());
		Object object=arg3.invokeSuper(arg0, arg2);
		System.out.println("After"+arg1.getName());
		return object;
	}
}
