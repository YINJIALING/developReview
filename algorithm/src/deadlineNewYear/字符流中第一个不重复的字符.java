package deadlineNewYear;

import java.util.HashMap;

public class 字符流中第一个不重复的字符 {
	StringBuffer str=new StringBuffer();
	char[] count=new char[256];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void Insert(char ch)
    {
        str.append(ch);
        count[hash(ch)]++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	char[] array=str.toString().toCharArray();
    	for(int i=0;i<str.length();i++) {
			if(count[hash(array[i])]==1) {
				return array[i];
			}
				
		}
    	return '#';
    }
    
    private static int hash(char c) {
		//为字符建立哈希映射，映射array的数组下标
		//下标：字符，值：出现的次数
		return c+128;
	}

}
