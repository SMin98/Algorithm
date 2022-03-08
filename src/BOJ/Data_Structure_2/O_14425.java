package BOJ.Data_Structure_2;

import java.io.*;
import java.util.ArrayList;

public class O_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //문자열 갯수
        String[] num=(bf.readLine().split(" "));
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(bf.readLine());
        }

        int answer = 0;
        for (int j = 0; j < m; j++) {
            String str = bf.readLine();
            if (arr.contains(str)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
