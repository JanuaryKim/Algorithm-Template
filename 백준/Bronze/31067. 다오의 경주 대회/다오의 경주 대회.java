import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] strNK = bf.readLine().split(" ");
        int n = Integer.parseInt(strNK[0]);
        int k = Integer.parseInt(strNK[1]);

        int[] a = Arrays.stream(bf.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        for(int i = 1; i < n; i++){
            if(a[i-1] >= a[i]){
                int temp = a[i] + k;
                if(a[i-1] >= temp){
                    System.out.println(-1);
                    return;
                }

                a[i] = temp;
                result++;
            }
        }

        System.out.println(result);
    }
}
