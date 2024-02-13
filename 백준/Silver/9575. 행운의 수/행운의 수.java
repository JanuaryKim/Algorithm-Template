import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] arr;
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        arr = new int[t][3][];

        for(int i = 0; i < t; i++){ //input 받기
            for(int j = 0; j < 3; j++){
                bf.readLine();
                arr[i][j] = Arrays.stream(bf.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
            }
        }

        for(int i = 0; i < t; i++){ //탐색
            map.put(i, new HashSet<>());
            dfs(i,0, 0);
        }

        for (int key : map.keySet()) { //답 출력
            System.out.println(map.get(key).size());
        }
    }

    private static void dfs(int testCase, int arrIdx, int sum){
        if(arrIdx > 2){
            if(checkLuckyNumber(sum)){
                map.get(testCase).add(sum);
            }
            return;
        }

        for (int i = 0; i < arr[testCase][arrIdx].length; i++) {
            dfs(testCase, arrIdx+1, sum + arr[testCase][arrIdx][i]);
        }
    }

    private static boolean checkLuckyNumber(int num){
        boolean result = true;
        while(num != 0){
            int res = num % 10;
            if(res == 5 || res == 8){
                num /= 10;
                continue;
            }
            return false;
        }
        return result;
    }
}
