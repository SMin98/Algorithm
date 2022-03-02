package BOJ.Data_Structure_2;

import java.io.*;
import java.util.HashMap;

public class O_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] q = bf.readLine().split(" ");
        int n = Integer.parseInt(q[0]); //도감 개수
        int m = Integer.parseInt(q[1]); //문제 수

        String[] nameList = new String[n + 1];
        HashMap<String, Integer> arr = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = bf.readLine();
            arr.put(name, i);
            nameList[i] = name;
        }

        for (int i = 1; i <= m; i++) {
            String str = bf.readLine();
            if (str.chars().allMatch(Character::isDigit)) {
                bw.write(nameList[Integer.parseInt(str)] + "\n");
            } else {
                bw.write((arr.get(str)) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

