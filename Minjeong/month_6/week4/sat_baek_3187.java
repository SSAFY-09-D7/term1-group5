import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class sat_baek_3187 {
    private static int[][] del = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int V, K;
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        boolean[][] v = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != '#' && !v[i][j]) bfs(i, j, arr, v);
            }
        }

        System.out.println(K + " " + V);
    }

    private static void bfs(int x, int y, char[][] arr, boolean[][] visited) {
        Queue<Node> q = new ArrayDeque<>();
        int v = 0, k = 0;
        visited[x][y] = true;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (arr[cur.x][cur.y] == 'v') v++;
            else if (arr[cur.x][cur.y] == 'k') k++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + del[i][0];
                int ny = cur.y + del[i][1];
                if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length
                        || visited[nx][ny] || arr[nx][ny] == '#') continue;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }

        if (k > v) K += k;
        else V += v;
    }
}
