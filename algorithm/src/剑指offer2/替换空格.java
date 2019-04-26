package 剑指offer2;

public class 替换空格 {

	public static void main(String[] args) {
		StringBuffer str=new StringBuffer("We are happy.");
		System.out.println(replaceSpace(str));
	}

	/**
	 * 1.先遍历字符串，统计空格的总数
	 * 2.根据空格的总数count, 计算替换后的字符串总长度=count*2原长度
	 * 3.初始化指针p1,p2, p1指向原长度最后，p2指向新长度最后
	 * 4.逐个拷贝，直到遇到第一个空格
	 * 5.用替换的字符加上
	 * @param str
	 * @return
	 */
	public static String replaceSpace(StringBuffer str) {
		
		int length=str.length(),count=0;//count记录空格个数
		for(int i=0;i<length;i++) {
			if(str.charAt(i)==' ')count++;
		}
		int newlength=length+2*count;//替换之后总长度
		int p1=length-1,p2=newlength-1;
		char c[]=new char[newlength];
		while(p1>=0&&p2>=0) {
			char tmp=str.charAt(p1);
			if(tmp!=' ')
				c[p2--]=str.charAt(p1--);
			else {
				p1--;
				c[p2--]='0';
				c[p2--]='2';
				c[p2--]='%';
			}		
		}
		StringBuffer res=new StringBuffer();
		for(char tmp:c)
			res.append(tmp);
		return res.toString();
	}

}
