import java.io.BufferedReader;
import java.io.InputStreamReader;

// 자연수 색칠하기
public class wed_baek_23048 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] color = new int[n + 1];
        boolean[] v = new boolean[n + 1];

        int idx = 1;
        color[1] = idx;
        for (int i = 2; i <= n; i++) {
            if (v[i]) continue;
            v[i] = true;
            color[i] = ++idx;
            for (int j = i * 2; j <= n; j += i) {
                if (v[j]) continue;
                v[j] = true;
                color[j] = idx;
            }
        }

        sb.append(idx).append("\n");
        for (int i = 1; i <= n; i++) {
            sb.append(color[i]).append(" ");
        }
        System.out.println(sb);
    }
}
