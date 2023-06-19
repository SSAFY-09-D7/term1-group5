import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class mon_baek_10282 {
    private static class Node implements Comparable<Node> {
        int x;
        int s;

        public Node(int x, int s) {
            this.x = x;
            this.s = s;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.s, o.s);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Node>[] graph;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n, d, c;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new Node(a, s));
            }

            int[] seconds = new int[n + 1];
            Arrays.fill(seconds, Integer.MAX_VALUE);
            seconds[c] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(c, 0));
            int cnt = 0, time = 0;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (seconds[cur.x] < cur.s) continue;
                cnt++;
                time = Math.max(time, cur.s);

                for (Node next: graph[cur.x]) {
                    if (seconds[next.x] > cur.s + next.s) {
                        seconds[next.x] = cur.s + next.s;
                        pq.offer(new Node(next.x, seconds[next.x]));
                    }
                }
            }

            sb.append(cnt).append(" ").append(time).append("\n");
        }
        System.out.println(sb);
    }
}
