import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static int n,m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {

            list.add(i);
            dfs(i, list);
            list.removeLast();
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int num, LinkedList<Integer> tempList) {

        if (tempList.size() == m) {

            for (Integer value : tempList) {
                sb.append(value + " ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = num; i <= n; i++) {
            tempList.add(i);
            dfs(i, tempList);
            tempList.removeLast();
        }
    }
}
