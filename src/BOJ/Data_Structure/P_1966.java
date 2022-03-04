package BOJ.Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(bf.readLine()); //테스트케이스 갯수
        for (int j = 0; j < testcase; j++) {
            String[] a = bf.readLine().split(" "); // 1,0 -> 문서갯수, 언제 인쇄되는지 궁금한 문서 위치
            String[] b = bf.readLine().split(" "); // 중요도

            Queue<Print> queue = new LinkedList<>();
            for (int i = 0; i < Integer.parseInt(a[0]); i++) {
                queue.add(new Print(i, b[i]));
            }

            int answer = 0;
            Arrays.sort(b);
            int len = b.length - 1;
            while (true) {
                String max = b[len];
                if (!queue.peek().prior.equals(max)) {
                    queue.add(queue.poll());
                } else {
                    if (queue.peek().num == Integer.parseInt(a[1])) {
                        answer++;
                        break;
                    } else {
                        queue.poll();
                        len--;
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static class Print {
        int num;
        String prior;

        public Print(int num, String prior) {
            this.num = num;
            this.prior = prior;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getPrior() {
            return prior;
        }

        public void setPrior(String prior) {
            this.prior = prior;
        }
    }
}