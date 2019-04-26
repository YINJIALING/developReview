package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 1.构建图
 * 2.判断该图是否有环
 */
public class 课程表 {

	public static void main(String[] args) {
		
		System.out.println(canFinish(2,new int[][]{{1,0}}));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		GraphNode[] graph=new GraphNode[numCourses];
		int[] visit=new int[numCourses];//-1表示没被访问过，0表示正在访问，1表示已完成访问
		//创建图的顶点
		for(int i=0;i<numCourses;i++) {
			visit[i]=-1;
			graph[i]=new GraphNode(i);
		}
		//创建图的边 
		//如果(课程1，课程2)，课程1依赖课程2，那么创建边课程2指向课程1
		for(int i=0;i<prerequisites.length;i++) {
			GraphNode begin=graph[prerequisites[i][1]];
			GraphNode end=graph[prerequisites[i][0]];
			begin.neighbors.add(end);
		}
		for(int i=0;i<graph.length;i++) {
			//如果节点没被访问过，进行dfs_search,如果遇到环，直接返回false
			if(visit[i]==-1&&DFS_search(graph[i],visit))
				return false;
		}
		return true;
	}

	/*
	 * 有环返回false
	 * 存在2种有环的情况
	 * 1.递归的过程发现有环
	 * 2.当前正在遍历的邻居中发现环
	 */
	private static boolean DFS_search(GraphNode graphNode, int[] visit) {
		visit[graphNode.label]=0;
		for(int i=0;i<graphNode.neighbors.size();i++) {
			if(visit[graphNode.neighbors.get(i).label]==-1) {
				if(!DFS_search(graphNode.neighbors.get(i),visit))
					return false;//
			}else if(visit[graphNode.neighbors.get(i).label]==0) {
				return false;
			}
		}
		visit[graphNode.label]=1;
		return true;
	}
	
	/*
	 * bfs,拓扑排序
	 * 1.统计每个节点的入度，存入degree
	 * 2.将入度为0的节点存入queue
	 * 3.遍历入度为0的节点的邻居，将其入度删去1，如果入度为0，继续放入queue
	 * 4.当queue为空，存在有节点入度不为0，发现有环，返回false
	 * 5.否则返回true
	 */
	private boolean canFinish2(int numCourses, int[][] prerequisites) {
		GraphNode[] graph=new GraphNode[numCourses];
		int[] degree=new int[numCourses];//入度数组
		for(int i=0;i<numCourses;i++) {
			graph[i]=new GraphNode(i);
		}
		for(int i=0;i<prerequisites.length;i++) {
			GraphNode begin=graph[prerequisites[i][1]];
			GraphNode end=graph[prerequisites[i][0]];
			begin.neighbors.add(end);
			degree[end.label]+=1;//入度+1
		}
		Queue<GraphNode> queue=new LinkedList<>();
		for(int i=0;i<numCourses;i++) {
			if(degree[i]==0)
				queue.add(graph[i]);
		}
		while(!queue.isEmpty()) {
			GraphNode node=queue.poll();
			for(int i=0;i<node.neighbors.size();i++) {
				degree[node.neighbors.get(i).label]--;
				if(degree[node.neighbors.get(i).label]==0)
					queue.add(node.neighbors.get(i));
			}
		}
	
		for(int i=0;i<numCourses;i++) {
			if(degree[i]!=0)
				return false;
		}
		return true;
	}

}
class GraphNode{
	int label;
	List<GraphNode> neighbors=new ArrayList<>();
	public GraphNode(int label) {
		super();
		this.label = label;
	}
	
}
