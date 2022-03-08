package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PP_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] answer = new int[n + 1];
        for (int i = 0; i <= n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1, list, answer, n);

        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> list, int[] answer, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        answer[start] = 1;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int item : list.get(parent)) {
                if (answer[item] == 0) {
                    answer[item] = parent;
                    queue.offer(item);
                }
            }
        }
    }
}
