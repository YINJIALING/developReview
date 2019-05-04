package 剑指offer2;

public class 翻转单词顺序列 {

	public static void main(String[] args) {
		System.out.println(ReverseSentence(""));
	}

	/**
	 * 1.先翻转整个句子
	 * 2.再翻转整个单词
	 * 
	 * @param str
	 * @return
	 */
	public static String ReverseSentence(String str) {
		if(str==null)return null;
		int pBegin=0,pEnd=str.length()-1;
		StringBuffer tmp=new StringBuffer(str);
		//
		Reverse(pBegin,pEnd,tmp);
		System.out.println(tmp.toString());
		String[] split=tmp.toString().split(" ");
		StringBuffer res=new StringBuffer();
		for(int i=0;i<split.length;i++) {
			StringBuffer splitsbf=new StringBuffer(split[i]);
			Reverse(0,split[i].length()-1,splitsbf);
			res.append(splitsbf+" ");
		}
		try {
			res.replace(res.length()-1, res.length(), "");
		}catch(Exception e){
            return str;
        }
		return res.toString();
	}

	/**
	 * 反转函数
	 * @param pBegin
	 * @param pEnd
	 */
	private static void Reverse(int pBegin, int pEnd,StringBuffer str) {
		while(pBegin<pEnd) {
			char tmp=str.charAt(pBegin);
			str.setCharAt(pBegin, str.charAt(pEnd));
			str.setCharAt(pEnd, tmp);
			pBegin++;pEnd--;
		}
	}


}
