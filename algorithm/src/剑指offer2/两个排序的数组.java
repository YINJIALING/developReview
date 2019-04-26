package 剑指offer2;
/**
 * 两个排序的数组a和b，a有足够大的内存容纳b,
 * 将b所有数字插入a,并且所有的数字是排序的
 * @author yinjialing
 *
 */
public class 两个排序的数组 {
	public static void main(String[] args) {
		int[] res=sort(new int[] {1,2,3,0,0},new int[]{2,4});
		for(int index:res) {
			System.out.print(index+",");
		}
	}
	 /*
	  * 1.初始化三个指针p1指向a有值得最后一个，p2指向b的最后一个，index指向a的最后一个
	  * 2. 根据大小，判断是把a[p1]拷贝至a[index]，还是把b[p2]拷贝至a[index]
	  */
	private static int[] sort(int[] a,int[] b) {
		int p1=0,p2=b.length-1,index=a.length-1;
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				p1=i-1;
				break;
			}
		}
		while(p1>=0&&p2>=0) {
			if(a[p1]>=b[p2]) {//把a[p1]拷贝至a[index]
				a[index--]=a[p1--];
			}else {
				a[index--]=b[p2--];
			}
		}
		return a;
	}
}
