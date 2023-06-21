import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class wed_baek_1939 {
    private static class Node implements Comparable<Node> {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.w, this.w);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] weights = new int[n + 1];
        boolean[] v = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, Integer.MAX_VALUE));
        weights[start] = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.e == end) break;
            v[cur.e] = true;

            for (Node next : graph[cur.e]) {
                if (v[next.e]) continue;
                int weight = Math.min(weights[cur.e], next.w);
                if (weights[next.e] < weight) {
                    weights[next.e] = weight;
                    pq.offer(next);
                }
            }
        }

        System.out.println(weights[end]);
    }
}