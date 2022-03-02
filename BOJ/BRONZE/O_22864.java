package BOJ.BRONZE;

import java.io.*;

public class O_22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = bf.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int m = Integer.parseInt(arr[3]);

        int pero = 0;
        int work = 0;

        if (a > m) {
            System.out.println(work);
            return;
        }

        for (int i = 0; i < 24; i++) {
            if (pero + a <= m) {
                pero += a;
                work += b;
            } else {
                if (pero - c < 0) {
                    pero = 0;
                } else {
                    pero -= c;
                }
            }
        }
        System.out.println(work);
    }
}

