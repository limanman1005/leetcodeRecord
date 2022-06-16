package mySummary.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: CloneGraph
 * Description:
 * date: 2/6/2022 下午9:24
 *
 * @author liyh
 */
public class CloneGraph {
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
class Solution133{
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node, Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while(!queue.isEmpty()){
            Node curCopyNode = queue.pollFirst();
            //创建每一条没有被创建的节点
            for(Node curNodeNeighbor : curCopyNode.neighbors){
                //使用了map没有包含这是还没有创建
                if(!visited.containsKey(curNodeNeighbor)){
                    queue.add(curNodeNeighbor);
                    visited.put(curNodeNeighbor, new Node(curNodeNeighbor.val, new ArrayList<>()));
                }
                //放入边的关系
                visited.get(curCopyNode).neighbors.add(visited.get(curNodeNeighbor));
            }
        }
        return visited.get(node);
    }
}
