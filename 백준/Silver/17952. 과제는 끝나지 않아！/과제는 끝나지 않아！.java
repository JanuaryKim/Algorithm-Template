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

        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int[] work = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            if(work[0] == 1){
                work[2]--;
                if(work[2] == 0){
                    result += work[1];
                    continue;
                }
                stack.push(work);
            } else{
                if (!stack.isEmpty()) {
                    int[] w = stack.pop();
                    w[2]--;
                    if(w[2] == 0){
                        result += w[1];
                        continue;
                    }
                    stack.push(w);
                }
            }
        }
        System.out.println(result);
    }
}
