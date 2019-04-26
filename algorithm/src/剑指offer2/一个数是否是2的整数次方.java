package 剑指offer2;

public class 一个数是否是2的整数次方 {

	//如果是，其二进制上只有一位1，其他所有都是0
	public static void main(String[] args) {
		int n=2;
		int count=0;
		int flag=1;
		while(flag!=0) {
			if((n&flag)!=0)
				count++;
			flag=flag<<1;
		}

		System.out.println(count==1);
	}

}
