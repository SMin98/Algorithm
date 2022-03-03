package BOJ.Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class O_10828 {

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        n = Integer.parseInt(bf.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            str = bf.readLine();
            if (str.contains("push")) {
                String[] arr = str.split(" ");
                stack.push(Integer.valueOf(arr[1]));
            } else if (str.contains("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            } else if (str.contains("size")) {
                System.out.println(stack.size());
            } else if (str.contains("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (str.contains("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            }
        }
    }
}
