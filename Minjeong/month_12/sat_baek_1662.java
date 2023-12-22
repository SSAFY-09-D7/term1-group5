import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 압축
public class sat_baek_1662 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.push(stack2.pop() * stack.pop() + stack.pop());
            }
            else {
                if (c == '(' && stack.peek() != 0) {
                    stack.push(stack.pop() - 1);
                    stack.push(0);
                    stack2.push(s.charAt(i - 1) - '0');
                }
                else if (c != '(') stack.push(stack.pop() + 1);
            }
        }
        System.out.println(stack.pop());
    }
}