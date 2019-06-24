package easy;

public class InternDemo {

	public static void main(String[] args) {
		System.out.println(new Integer(50)==new Integer(50));//false new出来的对象
		System.out.println(new Integer(50).equals(new Integer(50)));//true
		Integer a=50,b=50;//相当于编译器为我们做了Integer.valueOf(50),自动装箱
		System.out.println(a==new Integer(50));//false,比较的是这2块的地址
		System.out.println(a==b);//true,根据基本类型比较
		System.out.println(new Integer(1200)==new Integer(1200));
	}

}
