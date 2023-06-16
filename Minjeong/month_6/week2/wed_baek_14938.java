import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class wed_baek_14938 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] itemCount = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCount[i] = Integer.parseInt(st.nextToken());
        }

        int[][] res = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
            res[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            res[a][b] = c;
            res[b][a] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (k == i || res[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 1; j <= n; j++) {
                    if (res[k][j] == Integer.MAX_VALUE || i == j || k == j) continue;
                    if (res[i][k] + res[k][j] < res[i][j]) res[i][j] = res[i][k] + res[k][j];
                }
            }
        }

        int maxCnt = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (res[i][j] <= m) cnt += itemCount[j];
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }
}
