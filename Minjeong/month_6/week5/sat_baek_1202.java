import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 보석 도둑
public class sat_baek_1202 {
    private static class Node implements Comparable<Node> {
        int weight;
        long price;

        public Node(int weight, long price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b));
        }

        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Collections.sort(list);

        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
        int idx = 0;
        long res = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && bag[i] >= list.get(idx).weight) {
                pq.offer(list.get(idx++).price);
            }
            if (pq.isEmpty()) continue;
            res += pq.poll();
        }

        System.out.println(res);
    }
}
