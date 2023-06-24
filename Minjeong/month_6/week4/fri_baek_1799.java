import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fri_baek_1799 {
    private static int res, res2, n;
    private static final int[][] del = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] v = new int[n][n];
        StringTokenizer st;

        int cnt2 = n * n / 2;
        int cnt1 = cnt2;
        if (n % 2 == 1) cnt1++;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    v[i][j] = -1;
                    if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) cnt1--;
                    else cnt2--;
                }
            }
        }

        count(0, v, 1, cnt1, 0, false);
        count(0, v, 1, cnt2, 0, true);

        System.out.println(res + res2);
    }

    private static void count(int cnt, int[][] v, int idx, int cc, int xx, boolean flag) {
        if (!flag && res > cnt + cc) return;
        if (flag && res2 > cnt + cc) return;

        if (cc == 0) {
            if (!flag) res = Math.max(res, cnt);
            else res2 = Math.max(res2, cnt);
            return;
        }

        int x = -1, y = -1;
        l: for (int i = xx; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!flag) {
                    if (i % 2 == 0 && j % 2 == 1) continue;
                    if (i % 2 == 1 && j % 2 == 0) continue;
                }
                else {
                    if (i % 2 == 0 && j % 2 == 0) continue;
                    if (i % 2 == 1 && j % 2 == 1) continue;
                }
                if (v[i][j] != 0) continue;
                x = i;
                y = j;
                break l;
            }
        }

        if (x == -1) return;
        v[x][y] = -1;
        count(cnt, v, idx + 1, cc - 1, x, flag);

        int ccc = cc - 1;
        v[x][y] = idx;
        int copyX = x;
        int copyY = y;
        for (int k = 0; k < 4; k++) {
            x = copyX;
            y = copyY;
            while (true) {
                x += del[k][0];
                y += del[k][1];
                if (x < 0 || x >= n || y < 0 || y >= n) break;
                if (v[x][y] == 0) {
                    ccc--;
                    v[x][y] = idx;
                }
            }
        }

        count(cnt + 1, v, idx + 1, ccc, copyX, flag);

        for (int i = xx; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j] == idx) v[i][j] = 0;
            }
        }
    }
}