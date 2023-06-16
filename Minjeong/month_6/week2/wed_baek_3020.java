import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개똥벌레
public class wed_baek_3020 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] down = new int[h + 1];
        int[] up = new int[h + 1];
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (i % 2 == 0) down[a]++;
            else up[h - a + 1]++;
        }

        for (int i = h - 1, j = 2; i > 0; i--, j++) {
            down[i] += down[i + 1];
            up[j] += up[j - 1];
        }

        int minCnt = 10000000;
        for (int i = 1; i <= h; i++) {
            down[i] += up[i];
            minCnt = Math.min(minCnt, down[i]);
        }

        int areaCnt = 0;
        for (int i = 1; i <= h; i++) {
            if (down[i] == minCnt) areaCnt++;
        }

        System.out.println(minCnt + " " + areaCnt);
    }
}
