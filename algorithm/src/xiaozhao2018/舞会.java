package xiaozhao2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 舞会 {
/**
 * 1.用一个二维数组来表示男女之间的心仪关系，如bool[i][j]=true表示：男i对女j心仪或女j对男i心仪
 * 2.遍历这个数组，从每个男人开始，记录每个男人需要的舞曲次数，为了实现愿望，返回最大的舞曲次数
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] line1=br.readLine().split(" ");
		int n=Integer.parseInt(line1[0]),m=Integer.parseInt(line1[1]);
		boolean[][] bool=new boolean[n+1][m+1];
		for(int i=1;i<=n;i++) {
			String[] temp=br.readLine().split(" ");
			for(int j=1;j<=Integer.parseInt(temp[0]);j++) {
				bool[i][Integer.parseInt(temp[j])]=true;
			}
		}
		for(int i=1;i<=m;i++) {
			String[] temp=br.readLine().split(" ");
			for(int j=1;j<=Integer.parseInt(temp[0]);j++) {
				bool[Integer.parseInt(temp[j])][i]=true;
			}
		}
		br.close();
		int res=0;
		for(int i=1;i<=n;i++) {
			int tmp=0;
			for(int j=1;j<=m;j++) {
				if(bool[i][j])tmp++;
			}
			if(tmp>res)res=tmp;
		}
		System.out.println(res); 
	}

}
