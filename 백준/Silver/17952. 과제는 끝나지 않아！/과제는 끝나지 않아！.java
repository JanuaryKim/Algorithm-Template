import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] works = new int[n][3];

        for(int i = 0; i < n; i++){
            int[] work = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            works[i] = work;
        }

        Stack<int[]> stack = new Stack<>();
        int time = 0;
        while(time < n){
            time++;

            if(works[time-1][0] != 0){
                int[] w = works[time-1];
                w[2] -= 1;
                if(w[2] == 0) {
                    result += w[1];
                    continue;
                }
                stack.push(w);
            }
            else{
                if(!stack.isEmpty()){
                    int[] w = stack.pop();
                    w[2] -= 1;
                    if(w[2] == 0){
                        result += w[1];
                    }
                    else
                        stack.push(w);
                }
            }
        }
        System.out.println(result);
    }
}
