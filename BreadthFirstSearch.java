import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreadthFirstSearch {
    private static final int EDGE_WEIGHT = 6;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numQueries = scan.nextInt();
        for (int q = 0; q < numQueries; q++) {
            int numNodes = scan.nextInt();
            int numEdges = scan.nextInt();
            Node [] node = new Node[numNodes + 1]; 
            node[0] = null;
            for (int i = 1; i <= numNodes; i++) {
                node[i] = new Node(i);
            }
            for (int i = 0; i < numEdges; i++) {
                int n1 = scan.nextInt();
                int n2 = scan.nextInt();
                node[n1].addNeighbor(node[n2]);
            }
            int start = scan.nextInt();
            findDistances(node[start]);
            for (int i = 1; i <= numNodes; i++) {
                if (i != start) {
                    System.out.print(node[i].distance + " ");
                }
            }
            System.out.println();
        }
        scan.close();
    }
    private static void findDistances(Node start) {
        if (start == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>(); 
        start.distance = 0;
        deque.add(start);
        while (!deque.isEmpty()) {
            Node curr = deque.remove();
            for (Node neighbor : curr.neighbors) {
                if (neighbor.distance == -1) { 
                    neighbor.distance = curr.distance + EDGE_WEIGHT;
                    deque.add(neighbor);
                }
            }
        }
    }
}
class Node {
        public final int id; 
        public int distance;
        public HashSet<Node> neighbors;
        public Node (int id) {
            this.id   = id;
            distance  = -1;
            neighbors = new HashSet<>();
        }
        public void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }
        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            } else if (other == null || !(other instanceof Node)) {
                return false;
            }
            Node otherNode = (Node) other;
            return this.id == otherNode.id;
        }
        @Override
        public int hashCode() {
            return id; // simple and effective
        }
}
