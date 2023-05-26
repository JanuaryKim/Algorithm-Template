import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int n;
    static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        String sNum;
        for(int i=1; i<=n; i++) {
            visited[i] = true;
            sNum = Integer.toString(i);
            //System.out.println("sNum: " + sNum);
            dfs(sNum, i, 1);
            visited[i] = false;
        }
    }

    static void dfs(String sNum, int start, int depth) {
        if(depth>=n) {
            System.out.println(sNum);
        }
        else {
            for(int i=1; i<=n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    sNum += " "+i;
                    dfs(sNum, start, depth+1);
                    sNum = sNum.substring(0, sNum.length()-2);
                    visited[i] = false;
                }
            }
        }
    }

}