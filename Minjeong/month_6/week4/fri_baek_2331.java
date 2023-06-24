import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 반복수열
public class fri_baek_2331 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 1;
        map.put(a, cnt++);
        int sum;
        while (true) {
            sum = 0;
            while (a > 0) {
                sum += (int) Math.pow(a % 10, b);
                a /= 10;
            }
            if (map.get(sum) != null) break;
            map.put(sum, cnt++);
            a = sum;
        }

        System.out.println(map.get(sum) - 1);
    }
}
