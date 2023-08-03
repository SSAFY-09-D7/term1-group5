import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class fri_baek_2623 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] works = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int a = Integer.parseInt(st.nextToken());
                works[a] += 1;
                graph[pre].add(a);
                pre = a;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (works[i] == 0) q.offer(i);
        }
        Queue<Integer> res = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.offer(cur);

            for (int next : graph[cur]) {
                if (works[next] == 0) continue;
                works[next]--;
                if (works[next] == 0) q.offer(next);
            }
        }

        if (res.size() != n) {
            System.out.println(0);
            return;
        }
        while (!res.isEmpty()) {
            System.out.println(res.poll());
        }
    }
}