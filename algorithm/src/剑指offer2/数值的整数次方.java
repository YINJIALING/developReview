package 剑指offer2;

public class 数值的整数次方 {

	//使用库函数math.pow(base,exponent)
	public static void main(String[] args) {
		System.out.println(Power(2,-1));

	}

	/**
	 * 需考虑以下几种情况
	 * 1.base=0
	 * 2.exponent<0
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double Power(double base, int exponent) {
		if(exponent<0&&base==0) {
			return 0;
		}
		int absExponent=exponent;
		if(exponent<0)
			absExponent=0-absExponent;
		
		double result=powerWithExponent2(base,absExponent);
		if(exponent<0)
			result=1.0/result;
		
		return result;
	}

	private static double powerWithExponent(double base, int absExponent) {
		double result=1.0;
		for(int i=1;i<=absExponent;i++) {
			result*=base;
		}
		return result;
	}
	
	/**
	 * 递归式
	 * exponent为偶数，res=base^(exponent/2)*base^(exponent/2)
	 * exponent为奇数，res=base^((exponent-1)/2))*base^((exponent-1)/2)*base
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double powerWithExponent2(double base, int exponent) {
		if(exponent==0)
			return 1;
		if(exponent==1)return base;
		double result=powerWithExponent2(base,exponent>>1);
		result*=result;
		//如果是奇数的话
		if((exponent&1)==1)
			result=result*base;
		return result;
	}

	

}
