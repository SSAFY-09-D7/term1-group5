import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 패션왕 신해빈
public class thu_baek_9375 {
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            res = 1;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (map.containsKey(b)) map.replace(b, map.get(b) + 1);
                else map.put(b, 1);
            }

            for (String key: map.keySet()) {
                res *= (map.get(key) + 1);
            }

            System.out.println(res - 1);
        }
    }
}
