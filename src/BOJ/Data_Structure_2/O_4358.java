package BOJ.Data_Structure_2;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

public class O_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>();

        DecimalFormat df = new DecimalFormat("0.0000");

        //전체 갯수
        int n = 0;

        while (true) {
            String tree = bf.readLine();
            if (tree == null || tree.length() == 0) {
                break;
            }
            n += 1;
            if (!map.containsKey(tree)) {
                map.put(tree, 1);
            } else {
                map.put(tree, map.get(tree) + 1);
            }
        }

        Object[] mapkey = map.keySet().toArray();
        Arrays.sort(mapkey);

        for (Object key : mapkey) {
            String str = (String) key;
            int a = map.get(str);
            bw.write(str + " " + df.format(a * 100.0 / (double) n) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
