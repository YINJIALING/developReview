package 在线oj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JudgeByFile {
	private static final String DIRECTORY="/Users/yinjialing/Desktop";
	private static final String FILENAME="Demo.java";

	public static void main(String[] args) {
		//String input=input();
		// TODO Auto-generated method stub
		process();
		
	}
	
	
	private static void process() {
		//加载输入的文件
		File folder=new File(DIRECTORY);
		File sourceFile=new File(folder,FILENAME);
		
		// 加载java编译器环境
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		if(compiler==null)
			System.out.println("load error");
		else 
			System.out.println("load success");
		//编译传入的文件；
		int compiladtionResult=compiler.run(null, null, null, DIRECTORY+"/"+FILENAME);
		if(compiladtionResult==0)
			System.out.println("compile success");
		else
			System.out.println("compile fail");
		//类加载器
		try {//使用file.toURI().toURL()将文件转成url(连接)，
//		URLClassLoader classLoader=
//				URLClassLoader.newInstance(new URL[] {folder.toURI().toURL()});
			URLClassLoader classLoader=
					URLClassLoader.newInstance(new URL[] {folder.toURL()
					});
		//动态加载类（也可以是其他类型的文件）：URLClassLoader可以加载任意路径下的类,所以这里可以不用引用Demo这个类
		Class<?> cls=Class.forName("Demo",true,classLoader);//初始化
		Object instance=cls.newInstance();//实例化对象，这里的作用同下行
		//Object instance=new Object();
		//区别是new=初始化+实例化；这里先初始化再实例化，使得更灵活；
		//使用class.forName()时，jvm查找并加载指定的类（jvm执行静态代码段）；使用new的时候，这个类可以没被加载
		Method method=cls.getDeclaredMethod("run", null);//get公有方法run,传入的参数是null
		method.invoke(instance, null);// 调用方法
		//System.out.println(method.invoke(instance, null));//没返回值，所以这里是null
			//int res=method.invoke(instance, null);//有返回值的
		
		//删除临时文件
		classLoader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 读入一个文本文件
//	private static String input() {
//		File file=new File(FILENAMES);
//		file.getP
//		StringBuffer res=new StringBuffer();
//		try {
//			BufferedReader reader=new BufferedReader(new FileReader(file));		
//			String temp=null;
//			while((temp=reader.readLine())!=null) {
//				res.append(temp);
//			}
//			reader.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("Exception");
//		}
//		return res.toString();
//	}

}
