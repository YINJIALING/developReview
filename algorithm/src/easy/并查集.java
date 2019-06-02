package easy;

/*
 * https://128kj.iteye.com/blog/1708897
 */
public class 并查集 {
	

	public static void main(String[] args) {
		//10组人，7组亲戚关系
		int n=10,m=7;
		int[] father=new int[n+1];
		int[] rank=new int[n+1];
		make_set(father,rank);
		
		//已知的两两有关联的亲戚关系
		int[][] relationship= {{2,4},{5,7},{1,3},{8,9},{1,2},{5,6},{2,3}};
		//
		for(int i=0;i<m;i++) {
			int a=relationship[i][0];
			int b=relationship[i][1];		
			int x=FindSet(a,father);
			int y=FindSet(b,father);
			union(x,y,father);
		}
		int[][] questions= {{3,4},{7,10},{8,9}};
		for(int i=0;i<questions.length;i++) {
			int x=questions[i][0];
			int y=questions[i][1];
			if(FindSet(x,father)==FindSet(y,father))
				System.out.println("T");
			else
				System.out.println("F");
		}

	}

	//
	private static void union(int x, int y,int[] father) {
		int f1=FindSet(x,father);
		int f2=FindSet(y,father);
		if(f1!=f2)
			father[f1]=f2;
	}

	//回溯寻找路径
	private static int FindSet(int a, int[] father) {
		if(a!=father[a])
			father[a]=FindSet(father[a],father);
		return father[a];
	}

	//
	private static void make_set(int[] father, int[] rank) {
		for(int i=0;i<father.length;i++) {
			father[i]=i;rank[i]=0;
		}
		
	}

}

