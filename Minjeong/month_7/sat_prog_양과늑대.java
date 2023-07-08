import java.util.ArrayList;
import java.util.List;

public class sat_prog_양과늑대 {

    class Solution {
        int answer;
        List<Integer>[] graph;

        public int solution(int[] info, int[][] edges) {
            graph = new List[info.length];
            for (int i = 0; i < info.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            dfs(0, 0, 1, 0, new int[info.length], info);
            return answer;
        }

        private void dfs(int node, int depth, int sheep, int wolf,
                         int[] v, int[] info) {
            if (sheep <= wolf) return;
            if (depth == info.length) return;
            answer = Math.max(answer, sheep);
            v[node]++;
            for (int i : graph[node]) {
                if (v[i] < 3) {
                    if (v[i] == 0) dfs(i, depth + 1,
                            sheep + (info[i]^1), wolf + info[i],
                            v, info);
                    else dfs(i, depth, sheep, wolf, v, info);
                }
            }
            v[node]--;
        }
    }
}
