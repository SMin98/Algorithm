package BOJ.Greedy;

import java.io.*;

public class O_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int two = 0;
        int five = 0;

        if (n == 1||n == 3) {
            System.out.println(-1);
            return;
        }

        if ((n % 5) % 2 == 0) {
            five = n / 5;
            two = (n % 5) / 2;
        } else {
            five = n / 5 - 1;
            two = (n - (5 * five)) / 2;
        }

        System.out.println(two + five);
    }
}
