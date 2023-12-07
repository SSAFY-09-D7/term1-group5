public class 연속된부분수열의합 {

    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {0, 0};

            int start = 0, end = 0, sum = sequence[0];
            int len = 1000001;
            while (start < sequence.length && end < sequence.length) {
                if (sum == k) {
                    int gap = end - start + 1;
                    if (gap < len) {
                        len = gap;
                        answer[0] = start;
                        answer[1] = end;
                    }
                    end++;
                    if (end < sequence.length) sum += sequence[end];
                }
                else if (sum < k) {
                    end++;
                    if (end < sequence.length) sum += sequence[end];
                }
                else {
                    sum -= sequence[start];
                    start++;
                }
            }
            return answer;
        }
    }
}
