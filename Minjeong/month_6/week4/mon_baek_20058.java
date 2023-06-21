import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 마법사 상어와 파이어스톰
public class mon_baek_20058 {
    private static int[][] del = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] arr, tmp;
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
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, n);
        arr = new int[len][len];
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0, cnt = 0;
        st = new StringTokenizer(br.readLine());
        while (q-- > 0) {
            int a = Integer.parseInt(st.nextToken());
            int l = (int) Math.pow(2, a);

            tmp = new int[len][len];
            for (int i = 0; i < len; i += l) {
                for (int j = 0; j < len; j += l) {
                    rotate(i, j, l);
                }
            }
            arr = tmp;

            tmp = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    tmp[i][j] = arr[i][j];
                    int near = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + del[k][0];
                        int y = j + del[k][1];
                        if (x < 0 || x >= len || y < 0 || y >= len || arr[x][y] < 1) continue;
                        near++;
                    }
                    if (near < 3 && arr[i][j] != 0) tmp[i][j]--;
                }
            }

            arr = tmp;
        }

        boolean[][] v = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum+= arr[i][j];
                if (arr[i][j] > 0 && !v[i][j]) {
                    cnt = Math.max(cnt, bfs(len, arr, v, i, j));
                }
            }
        }

        System.out.println(sum + "\n" + cnt);
    }

    private static int bfs(int len, int[][] arr, boolean[][] v, int sx, int sy) {
        v[sx][sy] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sx, sy));
        int cnt = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int x = cur.x + del[i][0];
                int y = cur.y + del[i][1];
                if (x < 0 || x >= len || y < 0 || y >= len || v[x][y] || arr[x][y] < 1) continue;
                v[x][y] = true;
                q.offer(new Node(x, y));
            }
        }

        return cnt;
    }

    private static void rotate(int r, int c, int div) {
        for (int i = 0; i < div; i++) {
            for (int j = 0; j < div; j++) {
                tmp[j + r][c + div - i - 1] = arr[i + r][j + c];
            }
        }
    }
}