package 正则;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式匹配一对 {
//	public static List getContext(String html) {
//        List resultList = new ArrayList();
//        Pattern p = Pattern.compile(">([^</]+)</");//正则表达式 commend by danielinbiti
//        Matcher m = p.matcher(html );//
//        while (m.find()) {
//            resultList.add("《"+m.group(1)+"》");//
//        }
//        return resultList;
//    }
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		String a = "<doc>abc</doc><title>3232</title> <doc>只要内容</doc>";
//	    List list = getContext(a);
//	    System.out.println(list);
//	}
//	public static void main(String[] args) {
////		String jsonStr = "[{param1=<2018息,科008,业,测部>, param2=<20189-2>, param3=<重复>, demandNo=<2018044>}]";
//		String jsonStr = "param1=<2018息,科008,业,测部>, param2=<20189-2>, param3=<重复>, demandNo=<2018044";
//        StringBuilder sbuf = new StringBuilder();
//        Pattern p= Pattern.compile("(<*>)");//Pattern p= Pattern.compile("('[^']*')");
//        //
//        Matcher m=p.matcher(jsonStr);
//        int index = 0;
//        while (m.find()) {
//            sbuf.append(jsonStr.substring(index, m.start()));
//            sbuf.append(m.group(1).replaceAll("<", "《"));
//            sbuf.append(m.group(1).replaceAll(">", "》"));
//            index = m.end();
//        }
//        sbuf.append(jsonStr.substring(index));
//        System.out.println(sbuf.toString());
//	}
	public static void main(String[] args) {
		String msg = "PerformanceManager<第1个中括号><Product第2个中括号><第3个中括号>0000000<dsv>>";
		String res= extractMessageByRegular(msg);
		System.out.println(res);
		
		

	}
public static String extractMessageByRegular(String msg){
		
		StringBuffer sbuf=new StringBuffer();
		//"(\\[[^\\]]*\\])"
		//https://blog.csdn.net/tianpy5/article/details/52205776/中括号
		//(\([^\)]*\))
		//(\([^\)]*\))小括号
		//(?<=\\{)(.+?)(?=\\})大括号
		Pattern p = Pattern.compile("(\\<[^\\>]*\\>)");
		Matcher m = p.matcher(msg);
		int index = 0;
			while(m.find()){
				sbuf.append(msg.substring(index, m.start()));
				sbuf.append("《"+m.group().substring(1, m.group().length()-1)+"》");
				index = m.end();
			}
			sbuf.append(msg.substring(index));

		
		return sbuf.toString();

}


}
