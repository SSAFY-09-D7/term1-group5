import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_baek_1561 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        long start = 0, end = 0;
        for (int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        if (n <= m) {
            System.out.println(n);
            return;
        }

        end *= n;
        long time = 0;
        long cnt;
        while (start <= end) {
            long mid = (start + end) / 2;
            cnt = m;
            for (int i = 1; i <= m; i++) {
                cnt += mid / arr[i];
            }

            if (cnt < n) start = mid + 1;
            else {
                end = mid - 1;
                time = mid;
            }
        }

        cnt = m;
        for (int i = 1; i <= m; i++) {
            cnt += (time - 1) / arr[i];
        }

        for (int i = 1; i <= m; i++) {
            if (time % arr[i] == 0) cnt++;
            if (cnt == n) {
                System.out.println(i);
                break;
            }
        }
    }
}
