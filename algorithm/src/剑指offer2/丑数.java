package 剑指offer2;

public class 丑数 {

	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(7));

	}

	/**
	 * 寻找一个计算丑数的方法
	 * 设当前已有丑数M，现在需要计算下一个最小丑数
	 * (该丑数一定是根据前面某一个丑数*2或3或5计算得来的，分别计为M2,M3,M5)
	 * 下一个丑数是min(M2,M3,M5)
	 * @param index
	 * @return
	 */
	public static int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;
		int[] pUglyNumbers=new int[index];
		//默认第一个丑数是1 
		pUglyNumbers[0]=1;
		//nextUglyIndex当前正在推进的丑数的坐标
		//pMultiply2乘2因子
		int nextUglyIndex=1,pMultiply2=0,pMultiply3=0,pMultiply5=0;
		while(nextUglyIndex<index) {
			int min=min(pUglyNumbers[pMultiply2]*2,pUglyNumbers[pMultiply3]*3,
					pUglyNumbers[pMultiply5]*5);
			pUglyNumbers[nextUglyIndex]=min;
			nextUglyIndex++;
			// 使用while,如：f(5)=6,f(1)*3=6,f(2)*2=6,虽然更新了，但未全部更新.(上一次最小值和下一个的最小值一样的)
			while(pUglyNumbers[pMultiply2]*2<=min)
				pMultiply2++;
			while(pUglyNumbers[pMultiply3]*3<=min)
				pMultiply3++;
			while(pUglyNumbers[pMultiply5]*5<=min)
				pMultiply5++;
		}
		return pUglyNumbers[index-1];
	}

	private static int min(int i, int j, int k) {
		int min=i>j?j:i;
		return (min>k?k:min);
	}

}
