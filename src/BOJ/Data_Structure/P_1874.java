package BOJ.Data_Structure;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        ArrayList<String> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();  //4 3 6 8 7 5 2 1
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.valueOf(bf.readLine()));
        }

        int idx = 1;
        while (idx<=n) {
            stack.push(idx);
            answer.add("+");
            while (queue.peek().equals(stack.peek())) {
                stack.pop();
                queue.poll();
                answer.add("-");
                if (stack.isEmpty()){
                    break;
                }
            }
            idx++;
        }

        if (!stack.isEmpty()){
            System.out.println("NO");
            return;
        }

        for (String a : answer) {
            bw.write(a + "\n");
        }
        bw.flush();
        bw.close();
    }
}
