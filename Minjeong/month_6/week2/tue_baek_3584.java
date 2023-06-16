import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class tue_baek_3584 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] tree = new int[n + 1];

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                tree[d] = c;
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();

            int start = a;
            while (true) {
                l1.add(start);
                if (start == 0) break;
                start = tree[start];
            }

            start = b;
            while (true) {
                l2.add(start);
                if (start == 0) break;
                start = tree[start];
            }

            l: for (Integer v1 : l1) {
                for (Integer v2 : l2) {
                    if (v1.equals(v2)) {
                        System.out.println(v1);
                        break l;
                    }
                }
            }
        }
    }
}