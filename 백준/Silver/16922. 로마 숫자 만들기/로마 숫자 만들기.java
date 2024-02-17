import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] numberCheck = new boolean[1001];
    static int[] num = new int[]{1,5,10,50};
    static int n;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int depth, int sum, int idx){

        if(depth >= n)
        {
            if(!numberCheck[sum]) {
                result++;
                numberCheck[sum] = true;
            }
            return;
        }

        for(int i = idx; i < num.length; i++){
            dfs(depth+1, sum + num[i], i);
        }
    }
}
