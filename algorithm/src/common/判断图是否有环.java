package common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * https://blog.csdn.net/login_sonata/article/details/78002042
 * @author yinjialing
 * 1.计算每个点的入度
 * 2.找出入度为0的节点们，存入一个队列
 * 3.遍历队列，删除响应的边
 *
 */
public class 判断图是否有环 {

	//邻接矩阵
	static int[][] graph;
	//结点个数和边的个数
	static int vNum,eNum;
	//记录每个每个节点的入度，初始化为0
	static int[] count;
	//用队列保存拓扑序列
	static Queue<Integer> queue=new LinkedList<>();
	
	static void create() {
		Scanner in=new Scanner(System.in);
		System.out.println("顶点个数vNum:");
		vNum=in.nextInt();
		System.out.println("边个数eNum:");
		eNum=in.nextInt();
		graph=new int[vNum+1][vNum+1];
//		for(int i=1;i<=vNum;i++) {
//			for(int j=1;j<=vNum;j++) {
//				graph[i][j]=0;
//			}
//		}
		System.out.println("输入边的头和尾");
		for(int k=1;k<=eNum;k++) {
			int i=in.nextInt(),j=in.nextInt();
			graph[i][j]=1;
		}
		count=new int[vNum+1];
		//将count所有值初始化为0
		Arrays.fill(count, 0);
		//计算每个点的入度
		for(int i=1;i<=vNum;i++) {
			for(int j=1;j<=vNum;j++) {
				if(graph[i][j]==1)
					count[j]+=1;
			}
		}
	}
	
	//拓扑排序
	static void topoSort() {
		//入度为0的节点的个数
		 int number=0;
		 //暂时存放拓扑序列
		 Queue<Integer> temp=new LinkedList<>();
		 //遍历图中所有节点，找到入度为0的节点放入队列
		 for(int i=1;i<=vNum;i++) {
			 if(count[i]==0)
				 queue.offer(i);
		 }
		 //删除被删除节点的出边，对应的节点的入度减1
		 while(!queue.isEmpty()) {
			int i=queue.peek();
			temp.offer(queue.poll());
			number++;
			for(int j=1;j<=vNum;j++) {
				if(graph[i][j]==1) {
					count[j]-=1;
					//出现了新的入度为0的节点，删除
					if(count[j]==0) {
						queue.offer(j);
					}
				}
			}
		 }
		 if(number!=vNum) {
			 System.out.println("存在入度为1的节点，该有向图是有回路的");
		 }else
			 System.out.println("不存在回路，拓扑序列为"+temp.toString());
	}
	
	public static void main(String[] args) {
		create();
		topoSort();
	}

}
