package BOJ.Data_Structure_2;

import java.io.*;
import java.util.PriorityQueue;

public class O_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<num> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(bf.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(queue.poll().n + "\n");
                }
            } else {
                queue.add(new num(x));

            }
        }

        bw.flush();
        bw.close();
    }

    public static class num implements Comparable<num> {
        int n;

        public num(int n) {
            this.n = n;
        }

        @Override
        public int compareTo(num o) {
            if (Math.abs(this.n) == Math.abs(o.n)) {
                return this.n < o.n ? -1 : 1;
            }
            return Math.abs(this.n) < Math.abs(o.n) ? -1 : 1;
        }
    }
}
