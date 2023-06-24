import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 두 배열의 합
public class wed_baek_2143 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> aSum, bSum;
        aSum = new ArrayList<>();
        bSum = new ArrayList<>();
        int aSize = setting(n, a, aSum);
        int bSize = setting(m, b, bSum);
        aSum.sort(null);
        bSum.sort(null);

        int ap = 0, bp = bSize - 1;
        long res = 0;
        while (ap < aSize && bp >= 0) {
            int sum = aSum.get(ap) + bSum.get(bp);
            if (sum < T) ap++;
            else if (sum > T) bp--;
            else {
                long aCnt = 1, bCnt = 1;
                int nap = ap, nbp = bp;
                while (nap + 1 < aSize && aSum.get(nap).equals(aSum.get(nap + 1))) {
                    aCnt++;
                    nap++;
                }
                while (nbp - 1 >= 0 && bSum.get(nbp).equals(bSum.get(nbp - 1))) {
                    bCnt++;
                    nbp--;
                }
                res += aCnt * bCnt;
                ap = nap + 1;
                bp = nbp - 1;
            }
        }

        System.out.println(res);
    }

    private static int setting(int n, int[] arr, List<Integer> sum) {
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }

        int size = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                sum.add(arr[i] - arr[j]);
                size++;
            }
        }
        return size;
    }
}