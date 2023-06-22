import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 옥상 정원 꾸미기
public class thu_baek_6198 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        long res = 0;
        int idx = 0;
        while (idx++ < n) {
            int input = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= input) stack.pop();
            res += stack.size();
            stack.push(input);
        }

        System.out.println(res);
    }
}
