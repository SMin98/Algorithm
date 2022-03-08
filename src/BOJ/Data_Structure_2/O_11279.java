package BOJ.Data_Structure_2;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class O_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(bf.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            } else {
                queue.add(x);
            }
        }
        bw.flush();
        bw.close();
    }
}
