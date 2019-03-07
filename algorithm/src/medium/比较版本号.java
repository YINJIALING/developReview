package medium;

public class 比较版本号 {

	public static void main(String[] args) {
//		System.out.println(compareVersion("0.1", "1.1"));
//		System.out.println(compareVersion("1.0.1", "1"));
//		System.out.println(compareVersion("1.0", "1"));
		System.out.println(compareVersion("1", "1.0.1"));
	}

	/**
	 * 1.按“.”拆成数组
	 * 2.数组分别比较每个位置的值的大小
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion(String version1, String version2) {
		String[] version1arr = version1.split("\\.");//因为用的是正则，所以需要加上“\\”
		String[] version2arr = version2.split("\\.");
		int i = 0, j = 0;

		while (i < version1arr.length && j < version2arr.length) {
			int count = Integer.parseInt(version1arr[i]) - Integer.parseInt(version2arr[j]);
			if (count == 0) {
				i++;
				j++;
			} else if (count > 0) {
				return 1;
			} else {
				return -1;
			}

		}
		while(version1arr.length > version2arr.length&&i < version1arr.length) {
			if(Integer.parseInt(version1arr[i])==0)i++;
			else return 1;			
		}
		
		while(version1arr.length < version2arr.length&&j < version2arr.length) {
			if(Integer.parseInt(version2arr[j])==0)j++;
			else return -1;			
		}

		return 0;

	}

}
