package newcodergirl;

import java.util.Scanner;

/**
 * 多行求两数和
 * @author yinjialing
 *
 */
//Scanner in = new Scanner(System.in);
//while (in.hasNextInt()) {//注意while处理多个case
//  int a = in.nextInt();
//  int b = in.nextInt();
//  System.out.println(a + b);
//}
public class Test1 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c=in.nextInt();
        System.out.println(count(a,b,c)); 
    }

	private static int count(int T, int S, int q) {
		int count=0;
		int curTime=S;
		int curSongPlay=0;//播放的时间
		double curSongLoad=q-1;//下载的时间
		while(curSongLoad<T) {
			//System.out.println("cur:"+curTime+",播放:"+curSongPlay+",下载："+curSongLoad+",count:"+count);
			if(curSongPlay==curSongLoad) {
				curSongPlay=0;
				count++;
			}
			curTime+=1;
			curSongLoad+=1-(double)1/q;
			curSongPlay+=1;		
		}
		return count;
	}

}
