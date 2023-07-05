import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class wed_baek_14940 {
    private static int[][] del = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] dist = new int[n][m];
        boolean[][] v = new boolean[n][m];
        Node dest = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) dest = new Node(i, j, 0);
                if (arr[i][j] == 0) dist[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j]) bfs(arr, dist, v, dest);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) sb.append(dist[i][j]).append(" ");
                else sb.append(-1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int[][] arr, int[][] dist, boolean[][] v, Node dest) {
        Queue<Node> q = new ArrayDeque<>();
        v[dest.x][dest.y] = true;
        dist[dest.x][dest.y] = 0;
        q.offer(dest);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + del[i][0];
                int ny = cur.y + del[i][1];
                if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length
                        || v[nx][ny] || arr[nx][ny] == 0) continue;
                dist[nx][ny] = cur.dist + 1;
                v[nx][ny] = true;
                q.offer(new Node(nx, ny, dist[nx][ny]));
            }
        }
    }
}
