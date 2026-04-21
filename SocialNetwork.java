import java.util.*;

public class SocialNetwork {
    static LinkedList<Integer>[] graph;

    public static void bfs(int start, int n) {
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int friend : graph[node]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    q.add(friend);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        graph = new LinkedList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new LinkedList<>();

        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(3);
        graph[2].add(4);

        System.out.println("Connected Friends using BFS:");
        bfs(0, n);
    }
}
