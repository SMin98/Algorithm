package BOJ.Data_Structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class O_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (true) {
            if (queue.size() <= 1) {
                break;
            }
            queue.remove();
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());
    }
}
