package BOJ.BRONZE;

import java.io.*;

public class O_2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = bf.readLine().split(" ");
        String str = arr[0];
        int B = Integer.parseInt(arr[1]);

        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > 60) {
                answer += (int) (Math.pow(B, str.length() - 1 - i) * ((int) c - 55));
            } else {
                answer += (int) (Math.pow(B, str.length() - 1 - i) * ((int) c - 48));
            }
        }

        System.out.println(answer);
    }
}
