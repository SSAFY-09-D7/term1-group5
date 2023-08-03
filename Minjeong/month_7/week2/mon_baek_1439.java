import java.util.Scanner;

public class mon_baek_1439 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int zero = 0, one = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = i;
            if (c == '0') zero++;
            else one++;
            while (idx < s.length() && s.charAt(idx) == c) i = idx++;
        }

        System.out.println(Math.min(zero, one));
    }
}
