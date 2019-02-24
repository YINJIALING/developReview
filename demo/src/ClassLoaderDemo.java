
public class ClassLoaderDemo {
public static void main(String[] args) {
	ClassLoader cl=ClassLoaderDemo.class.getClassLoader();
	System.out.println("cl classloader is"+cl.getParent().getParent().toString());//error
	
//	cl=int.class.getClassLoader();
//	System.out.println("cl classloader is"+cl.toString());//error
}
}
