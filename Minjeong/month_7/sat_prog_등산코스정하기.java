import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class sat_prog_등산코스정하기 {

    class Solution {
        private class Node implements Comparable<Node> {
            int to;
            int intensity;

            private Node(int to, int intensity) {
                this.to = to;
                this.intensity = intensity;
            }

            @Override
            public int compareTo(Node o) {
                if (this.intensity == o.intensity) {
                    return Integer.compare(this.to, o.to);
                }
                return Integer.compare(this.intensity, o.intensity);
            }
        }

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            List<Node>[] graph = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] path : paths){
                graph[path[0]].add(new Node(path[1], path[2]));
                graph[path[1]].add(new Node(path[0], path[2]));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            PriorityQueue<Node> res = new PriorityQueue<>();

            boolean[] v = new boolean[n + 1];
            for (int gate : gates) {
                pq.add(new Node(gate, 0));
                v[gate] = true;
            }

            Set<Integer> s = new HashSet<>();
            for (int summit : summits) {
                s.add(summit);
            }

            int minV = Integer.MAX_VALUE;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (minV < cur.intensity) continue;
                v[cur.to] = true;
                if (s.contains(cur.to)) {
                    res.offer(new Node(cur.to, cur.intensity));
                    minV = cur.intensity;
                    continue;
                }

                for (Node next : graph[cur.to]) {
                    int cost = Math.max(cur.intensity, next.intensity);
                    if (!v[next.to] && minV >= cost) {
                        pq.offer(new Node(next.to, cost));
                    }
                }
            }

            return new int[]{ res.peek().to, res.peek().intensity };
        }
    }
}
