import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;
    static int n,m;
    static int[] tempResult;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bf.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        String[] strArr = bf.readLine().split(" ");

        arr = new int[n];
        tempResult = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {

        if (depth == m) {

            for (int i = 0; i < tempResult.length; i++) {
                sb.append(tempResult[i] + " ");
            }

            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (visited[i] == false) {
                tempResult[depth] = arr[i];
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }

        }
    }
}
