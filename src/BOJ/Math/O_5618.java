package BOJ.Math;

import java.io.*;
import java.util.Arrays;

public class O_5618 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        int[] num = new int[n];
        String[] arr = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(num);

        int idx = 1;
        bw.write(1 + "\n");

        while (idx <= num[0]) {
            idx++;
            int hab = 0;
            for (int i : num) {
                if (i % idx == 0) {
                    hab++;
                }
            }
            if (hab == n) {
                bw.write(idx + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
