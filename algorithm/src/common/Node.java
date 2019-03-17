package common;

import java.util.List;

/**
 * 图结点
 * 
 * @author YJL
 *
 */
public class Node {
	public int val;
	public List<Node> neighbors;//邻居

	public Node() {
	}

	public Node(int _val, List<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
