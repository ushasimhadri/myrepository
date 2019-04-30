import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class Pair implements Comparable<Pair> {
    int node;
    int value;
    public Pair(int n, int v) {
        node = n;
        value = v;
    }
    public int compareTo(Pair b) {
        return (value < b.value) ? -1: 1;
    }
}
public class PrimsMST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        int w = 0;
        int n,m,S;
        n = sc.nextInt();
        m = sc.nextInt();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < m; i++) {
            int x, y, r;
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            r = sc.nextInt();
            adj.get(x).add(new Pair(y, r));
            adj.get(y).add(new Pair(x, r));
        }
        S = sc.nextInt() - 1;
        q.add(new Pair(S, 0));
        while (q.size() > 0) {
            Pair current = q.poll();
            if (!visited[current.node]) {
                for (int i = 0; i < adj.get(current.node).size(); i++) {
                    Pair tmp = adj.get(current.node).get(i);
                    if (!visited[tmp.node]) {
                        q.add(tmp);
                    }
                }
                w += current.value;
                visited[current.node] = true;
            }
        }
        System.out.println(w);
    }
}