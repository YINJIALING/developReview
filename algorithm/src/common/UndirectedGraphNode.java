package common;

import java.util.ArrayList;

public class UndirectedGraphNode {

	 private final int label;
	 
	 UndirectedGraphNode left=null;
	 
	 UndirectedGraphNode right=null;
	 
	 public ArrayList<UndirectedGraphNode> neighbors=new ArrayList<>();

	public UndirectedGraphNode getLeft() {
		return left;
	}



	public void setLeft(UndirectedGraphNode left) {
		this.left = left;
	}



	public UndirectedGraphNode getRight() {
		return right;
	}



	public void setRight(UndirectedGraphNode right) {
		this.right = right;
	}



	public ArrayList<UndirectedGraphNode> getNeighbors() {
		return neighbors;
	}



	public void setNeighbors(ArrayList<UndirectedGraphNode> neighbors) {
		this.neighbors = neighbors;
	}



	public UndirectedGraphNode(int label) {
		super();
		this.label = label;
	}



	public int getLabel() {
		return label;
	}
}
