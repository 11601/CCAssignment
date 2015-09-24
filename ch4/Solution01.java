import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Hakim on 9/19/15.
 */
class Graph{
    public Node[] nodes;
}

class Node{
    public int label;
    public Node[] children;

    public Node(int l){
        label = l;
    }
}

public class Solution01 {
    public static void main(String[] args){
        Solution01 solution01 = new Solution01();

        // graph1: {0,1#1,3#2,0#3,2,4#4,5#5} (cf serialization: https://leetcode.com/problems/clone-graph/)
        Graph graph1 = new Graph();
        Node a1 = new Node(0);
        Node b1 = new Node(1);
        Node c1 = new Node(2);
        Node d1 = new Node(3);
        Node e1 = new Node(4);
        Node f1 = new Node(5);

        Node[] a1Children = {b1};
        Node[] b1Children = {d1};
        Node[] c1Children = {a1};
        Node[] d1Children = {c1,e1};
        Node[] e1Children = {f1};

        a1.children = a1Children;
        b1.children = b1Children;
        c1.children = c1Children;
        d1.children = d1Children;
        e1.children = e1Children;

        System.out.println("Route between a1 and f1 in graph1: " + solution01.existsRoute(graph1, a1, f1));

        // graph2: {0,1#1,3#2,0#3,2#4,3,5#5}
        Graph graph2 = new Graph();
        Node a2 = new Node(0);
        Node b2 = new Node(1);
        Node c2 = new Node(2);
        Node d2 = new Node(3);
        Node e2 = new Node(4);
        Node f2 = new Node(5);

        Node[] a2Children = {b2};
        Node[] b2Children = {d2};
        Node[] c2Children = {a2};
        Node[] d2Children = {c2};
        Node[] e2Children = {d2,f2};

        a2.children = a2Children;
        b2.children = b2Children;
        c2.children = c2Children;
        d2.children = d2Children;
        e2.children = e2Children;

        System.out.println("Route between a2 and f2 in graph2: " + solution01.existsRoute(graph2, a2, f2));


    }

    /**
     * Find out whether there is a route from node a to node b.
     * @param graph
     * @param a
     * @param b
     * @return true if there is a route from node a to node b. False otherwise.
     */
    public boolean existsRoute(Graph graph, Node a, Node b){
        // We implement BFS
        if (graph == null || a == null || b == null){
            return false;
        }

        // Keep track of the nodes visited to avoid getting stuck in a cycle
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()){
            Node n = queue.remove();
            visited.add(n);

            for (Node child : n.children){
                if (child == b){
                    return true;
                }
                if (!visited.contains(child)){
                    queue.add(child);
                }
            }
        }

        return false;
    }
}
