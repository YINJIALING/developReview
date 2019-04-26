package medium;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

	public static void main(String[] args) {
//		generateParenthesis(3);
		List<String> res=generateParenthesis2(3);
		for(String item:res)
			System.out.print(item+",");
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		generateParenthesisCore(res, "", 0, 0, n);
		return res;
	}

	/**
	 * 
	 * @param res 结果集
	 * @param string 保存当前可能的字符串
	 * @param left 当前左括号个数
	 * @param right 当前右括号个数
	 * @param total 总个数
	 */
	private static void generateParenthesisCore(List<String> res, String string, int left, int right, int total) {
		
		//递归结束条件
		if(left==total&&right==total) {
			res.add(string);
			return;
		}
			
		//如果当前左括号个数小于总个数，则可以在当前可能的字符串加左括号，并递归
		if(left<total)
			generateParenthesisCore(res,string+"(",left+1,right,total);
		
		//如果当前右括号个数小于总个数，且右括号个数小于左括号的个数，则可以在当前可能的字符串加右括号，并递归
		if(right<total&&right<left)
//			if(right<total)
			generateParenthesisCore(res,string+")",left,right+1,total);
	}


	/**
	 * 递归辅助函数
	 *
	 * @param resultList
	 *            保存结果的list
	 * @param subString
	 *            保存当前可能组合的字符串
	 * @param leftNum
	 *            当前使用左括号个数
	 * @param rightNum
	 *            当前使用右括号个数
	 * @param totalNum
	 *            总个数
	 **/
	public void generate(List<String> resultList, String subString, int leftNum, int rightNum, int totalNum) {
		// 递归结束条件
		if (leftNum == totalNum && rightNum == totalNum) {
			resultList.add(subString);
			return;
		}
		// 如果左括号个数小于总数，则本次可以添加左括号，并继续递归
		if (leftNum < totalNum) {
			generate(resultList, subString + "(", leftNum + 1, rightNum, totalNum);
		}
		// 如果右括号小于总数，且右括号个数小于左括号，则本次可以添加右括号，并继续递归
		if (rightNum < totalNum && leftNum > rightNum) {
			generate(resultList, subString + ")", leftNum, rightNum + 1, totalNum);
		}
	}
	
	/**
	 * 合理的条件
	 * 1. 左括号的个数=右括号的个数=n
	 * 2.右括号的放置顺序不能先于左括号
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesis2(int n) {
		List<String> res=new ArrayList<>();
		generateParenthesis2Core("",n,n,res,n);
		return res;
	}

	/**
	 * 
	 * @param item 当前生成的字符串
	 * @param left 当前生成的字符串可以生成的（个数
	 * @param right 当前生成的字符串可以生成的)个数
	 * @param res 结果集
	 * @param n
	 */
	private static void generateParenthesis2Core(String item, int left, int right, List<String> res,int n) {
		if(item.length()==2*n&&left==0&&right==0) {//剪枝
			res.add(item);
			return ;
		}
		if(left>0)
			generateParenthesis2Core(item+"(",left-1,right,res,n);
		if(left<right)
			generateParenthesis2Core(item+")",left,right-1,res,n);
	}
	

}
