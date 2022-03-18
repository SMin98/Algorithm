package BOJ.Data_Structure;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class O_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n;
        n = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        int last = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            if (str.contains("push")) {
                String[] arr = str.split(" ");
                last = Integer.parseInt(arr[1]);
                queue.add(Integer.valueOf(arr[1]));
            } else if (str.contains("size")) {
                answer.add(queue.size());
            } else if (str.contains("empty")) {
                if (queue.isEmpty()) {
                    answer.add(1);
                } else {
                    answer.add(0);
                }
            } else if (str.contains("pop")) {
                if (queue.isEmpty()) {
                    answer.add(-1);
                } else {
                    answer.add(queue.poll());
                }
            } else if (str.contains("front")) {
                if (queue.isEmpty()) {
                    answer.add(-1);
                } else {
                    answer.add(queue.peek());
                }
            } else if (str.contains("back")) {
                if (queue.isEmpty()) {
                    answer.add(-1);
                } else {
                    answer.add(last);
                }
            }
        }

        for (int a : answer) {
            bw.write(a + "\n");
        }
        bw.flush();
        bw.close();
    }
}
