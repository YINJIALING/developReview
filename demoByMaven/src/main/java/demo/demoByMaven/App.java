package demo.demoByMaven;

import net.sf.cglib.proxy.Enhancer;

public class App 
{
    public static void main( String[] args )
    {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(HelloImpl.class);//继承被代理类
        enhancer.setCallback(new HelloMethodInterceptor());//设置回调
        HelloImpl helloService=(HelloImpl) enhancer.create();//生成代理类对象 
        helloService.sayHello();//调用该方法被我们实现的方法拦截器拦截
    }
}
