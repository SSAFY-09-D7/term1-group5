import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 가장 가까운 공통 조상
public class tue_baek_3584 {
    private static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer>[] tree = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = new ArrayList<>();
            }

            boolean[] tmp = new boolean[n + 1];
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
                tmp[b] = true;
            }

            int root = 0;
            for (int i = 1; i <= n; i++) {
                if (!tmp[i]) {
                    root = i;
                    break;
                }
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            flag = false;
            dfs(root, 0, tree, a, new int[n], new boolean[n + 1], l1);
            flag = false;
            dfs(root, 0, tree, b, new int[n], new boolean[n + 1], l2);

            for (int i = 0, j = 0; i < l1.size() && j < l2.size(); i++, j++) {
                if (!l2.get(i).equals(l1.get(i))) {
                    System.out.println(l1.get(i - 1));
                    break;
                }
                if (i == l2.size() - 1 || i == l1.size() - 1) {
                    System.out.println(l1.get(i));
                    break;
                }
            }
        }
    }

    private static void dfs(int node, int depth,
                            List<Integer>[] tree, int dest,
                            int[] res, boolean[] v, List<Integer> l) {
        v[node] = true;
        res[depth] = node;

        if (flag) return;
        if (node == dest) {
            for (int i = 0; i <= depth; i++) l.add(res[i]);
            flag = true;
            return;
        }

        for (int next : tree[node]) {
            if (!v[next])
                dfs(next, depth + 1, tree, dest, res, v, l);
        }
    }
}