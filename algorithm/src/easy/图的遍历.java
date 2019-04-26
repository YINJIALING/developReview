package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 图的深度遍历
 * 使用邻接表表示图
 * @author yinjialing
 *
 */
public class 图的遍历 {
 
	static int MAX_N=5;
	static GraphNode[] Graph=new GraphNode[MAX_N];
	public static void main(String[] args) {
		List<GraphNode> neighbors=new ArrayList<>();
		for(int i=0;i<MAX_N;i++)
			Graph[i]=new GraphNode(i);//创建图的顶点

		//添加图的边
		neighbors.add(Graph[4]);
		neighbors.add(Graph[2]);
		Graph[0].neighbors=new ArrayList<>(neighbors);
		neighbors.clear();
		neighbors.add(Graph[0]);
		neighbors.add(Graph[2]);
		Graph[1].neighbors=new ArrayList<>(neighbors);
		neighbors.clear();
		neighbors.add(Graph[2]);
		Graph[2].neighbors=new ArrayList<>(neighbors);neighbors.clear();
		neighbors.add(Graph[4]);
		Graph[3].neighbors=new ArrayList<>(neighbors);neighbors.clear();
		neighbors.add(Graph[3]);
		Graph[4].neighbors=new ArrayList<>(neighbors);neighbors.clear();
		int[] visit=new int[MAX_N];//标记每个图节点是否被访问过
		//dfs
//		for(int i=0;i<MAX_N;i++) {
//			if(visit[i]==0) {//如果没被访问过
//				System.out.print("从节点"+Graph[i].label+"开始:");
//				DFS_graph(Graph[i],visit);
//				System.out.println();
//			}
//		}
//		Arrays.fill(visit,0);
		//bfs
		for(int i=0;i<MAX_N;i++) {
			if(visit[i]==0) {
				System.out.print("从节点"+Graph[i].label+"开始:");
				BFS_graph(Graph[i],visit);
				System.out.println();
			}
		}
		
	}
	//bfs访问的主函数
	private static void BFS_graph(GraphNode graphNode, int[] visit) {
		Queue<GraphNode> queue=new LinkedList<>();
		queue.add(graphNode);
		visit[graphNode.label]=1;
		while(!queue.isEmpty()) {
			GraphNode node=queue.poll();
			System.out.print(node.label+",");
			for(int i=0;i<node.neighbors.size();i++) {
				if(visit[node.neighbors.get(i).label]==0) {
					visit[node.neighbors.get(i).label]=1;
					queue.add(node.neighbors.get(i));
				}
			}
		}
		
	}
	//dfs访问的主函数
	private static void DFS_graph(GraphNode graphNode, int[] visit) {
		visit[graphNode.label]=1;//标记已访问的节点
		System.out.print(","+graphNode.label);
		//访问该节点的没被访问过的其邻居
		for(int i=0;i<graphNode.neighbors.size();i++) {
			if(visit[graphNode.neighbors.get(i).label]==0)
				DFS_graph(graphNode.neighbors.get(i),visit);
		}
		
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
