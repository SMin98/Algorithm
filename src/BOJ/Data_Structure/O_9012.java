package BOJ.Data_Structure;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class O_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        String str;

        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            str = bf.readLine();
            if (str.charAt(0) == ')') {
                answer.add("NO");
                continue;
            }
            String[] arr = str.split("");

            Stack<String> stack = new Stack<>();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("(")) {
                    stack.push("(");
                } else {
                    if (stack.isEmpty()) {
                        stack.push(")");
                    } else {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            stack.push(")");
                        }
                    }
                }
            }

            if (stack.isEmpty()) {
                answer.add("YES");
            } else {
                answer.add("NO");
            }
        }
        for (String a : answer) {
            bw.write(a + "\n");
            bw.flush();
        }
        bw.close();
    }
}
