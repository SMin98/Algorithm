package BOJ.Data_Structure;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class O_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());  //5
        String str = bf.readLine(); //ABC*+DE/-

        ArrayList<Double> arr = new ArrayList<>(); //1,2,3,4,5 값
        for (int i = 0; i < n; i++) {
            arr.add(Double.valueOf(bf.readLine()));
        }

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(asd(str, arr))); //(A+(B*C))-(D/E)
    }

    public static Double asd(String str, ArrayList<Double> num) {
        Deque<Double> deque = new LinkedList<>();
        String[] arr = str.split("");
        for (int i = 0; i < arr.length; i++) {
            if (!Pattern.matches("[A-Z]", arr[i])) {
                double b = deque.pollLast();
                double a = deque.pollLast();
                if (arr[i].equals("/")) {
                    deque.addLast(a / b);
                } else if (arr[i].equals("+")) {
                    deque.addLast(a + b);
                } else if (arr[i].equals("-")) {
                    deque.addLast(a - b);
                } else {
                    deque.addLast(a * b);
                }
            } else {
                int a = arr[i].charAt(0) - 65;
                deque.addLast(num.get(a));
            }
        }
        return deque.peek();

    }
}
