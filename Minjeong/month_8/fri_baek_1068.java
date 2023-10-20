import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리
public class fri_baek_1068 {
    private static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> tree[] = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) root = i;
            else tree[node].add(i);
        }
        int eraseNode = Integer.parseInt(br.readLine());
        cnt = 0;
        count(root, tree, eraseNode);
        System.out.println(cnt);
    }

    private static void count(int node, List<Integer>[] tree, int eraseNode) {
        if (node == eraseNode) return;
        if (tree[node].size() == 0) {
            cnt++;
            return;
        }
        for (int next : tree[node]) {
            if (next == eraseNode && tree[node].size() == 1) cnt++;
            else if (next != eraseNode) count(next, tree, eraseNode);
        }
    }
}
