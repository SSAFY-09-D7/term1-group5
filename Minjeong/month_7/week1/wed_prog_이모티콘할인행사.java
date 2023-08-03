import java.util.Arrays;

public class wed_prog_이모티콘할인행사 {
    class Solution {
        private int cnt, total, size;

        public int[] solution(int[][] users, int[] emoticons) {
            int[] answer = new int[2];
            size = emoticons.length;

            solve(0, new int[users.length], users, emoticons);
            answer[0] = cnt;
            answer[1] = total;
            return answer;
        }

        private void solve(int depth, int[] totalSum, int[][] users, int[] emoticons) {
            if (depth == size) {
                int buyerCnt = 0, sum = 0;
                for (int i = 0; i < users.length; i++) {
                    if (totalSum[i] >= users[i][1]) buyerCnt++;
                    else sum += totalSum[i];
                }
                System.out.println(Arrays.toString(totalSum));
                if ((buyerCnt > cnt) || (buyerCnt == cnt && sum > total)) {
                    cnt = buyerCnt;
                    total = sum;
                }
                return;
            }

            for (int r = 1; r <= 40; r++) {
                int[] tmp = new int[users.length];
                for (int i = 0; i < users.length; i++) {
                    if (r < users[i][0]) continue;
                    int price = emoticons[depth] * (100 - r) / 100;
                    totalSum[i] += price;
                    tmp[i] = price;
                }
                solve(depth + 1, totalSum, users, emoticons);
                for (int i = 0; i < users.length; i++) {
                    totalSum[i] -= tmp[i];
                }
            }
        }
    }
}