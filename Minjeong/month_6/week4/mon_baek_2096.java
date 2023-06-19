import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mon_baek_2096 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] res = new int[2][3];
        for (int i = 1; i <= n; i++) {
            int a = res[0][0];
            int b = res[0][1];
            res[0][0] = Math.max(res[0][0], res[0][1]) + arr[i][0];
            res[0][1] = Math.max(Math.max(a, res[0][1]), res[0][2]) + arr[i][1];
            res[0][2] = Math.max(b, res[0][2]) + arr[i][2];

            a = res[1][0];
            b = res[1][1];
            res[1][0] = Math.min(res[1][0], res[1][1]) + arr[i][0];
            res[1][1] = Math.min(Math.min(a, res[1][1]), res[1][2]) + arr[i][1];
            res[1][2] = Math.min(b, res[1][2]) + arr[i][2];
        }

        Arrays.sort(res[0]);
        Arrays.sort(res[1]);
        System.out.println(res[0][2] + " " + res[1][0]);
    }
}
