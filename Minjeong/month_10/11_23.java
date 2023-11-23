import java.util.*;

class Solution {
    int answer;
    List<Integer>[] graph;
    boolean[][][] v;

    public int solution(int[] info, int[][] edges) {
        graph = new List[info.length];
        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        v = new boolean[info.length][info.length + 1][info.length + 1];
        dfs(0, 0, 0, v, info);
        return answer;
    }

    private void dfs(int node, int sheep, int wolf, boolean[][][] v, int[] info) {
        boolean flag = false;
        if (!v[node][0][0]) {
            sheep += info[node] ^ 1;
            wolf += info[node];
            flag = true;
        }
        
        if (sheep <= wolf || sheep + wolf > info.length) return;
        if (v[node][sheep][wolf]) return;
        
        if (flag) v[node][0][0] = true;
        v[node][sheep][wolf] = true;
        if (node == 0) {
            answer = Math.max(answer, sheep);
        }

        for (int next : graph[node]) {
            dfs(next, sheep, wolf, v, info);
        }
        
        if (flag) v[node][0][0] = false;
        v[node][sheep][wolf] = false;
    }
}
