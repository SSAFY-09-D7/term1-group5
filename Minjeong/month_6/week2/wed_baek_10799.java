import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
public class wed_baek_10799 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.substring(i, i + 2).equals("()")) {
                i++;
                res += st.size();
            }
            else if (s.charAt(i) == '(') st.push('(');
            else if (s.charAt(i) == ')') {
                st.pop();
                res++;
            }
        }

        System.out.println(res);
    }
}
