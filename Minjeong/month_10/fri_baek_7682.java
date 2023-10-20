import java.io.BufferedReader;
import java.io.InputStreamReader;

public class fri_baek_7682 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[3][3];
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            int x = 0, o = 0;
            for (int i = 0; i < 9; i++) {
                char c = s.charAt(i);
                if (c == 'X') x++;
                else if (c == 'O') o++;
                board[i / 3][i % 3] = c;
            }

            // 판이 꽉 찬 경우: 5:4
            if (x <= 2 && o <= 2) sb.append("invalid\n");
            else if (x == 5 && o == 4 && !check('O', board)) sb.append("valid\n");
            // x가 이긴 경우: n:n - 1
            else if (x - 1 == o && check('X', board) && !check('O', board)) sb.append("valid\n");
            // o가 이긴 경우: n:n
            else if (x == o && check('O', board) && !check('X', board)) sb.append("valid\n");
            else sb.append("invalid\n");
        }

        System.out.println(sb);
    }

    private static boolean check(char c, char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) return true;
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) return true;
        }
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;
        return false;
    }
}
