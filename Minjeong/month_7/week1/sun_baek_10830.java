import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sun_baek_10830 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] res = solve(b, arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solve(long b, int[][] arr) {
        if (b == 1) return arr;

        int[][] A = solve(b / 2, arr);
        int[][] C = new int[arr.length][arr.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int tmp = 0;
                for (int k = 0; k < A.length; k++) {
                    tmp += A[i][k] * A[k][j];
                }
                C[i][j] = tmp % 1000;
            }
        }

        if (b % 2 == 1) {
            int[][] B = new int[arr.length][arr.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    int tmp = 0;
                    for (int k = 0; k < A.length; k++) {
                        tmp += C[i][k] * arr[k][j];
                    }
                    B[i][j] = tmp % 1000;
                }
            }

            C = B;
        }

        return C;
    }
}