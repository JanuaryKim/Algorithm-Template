import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //2853
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] splLine = line.split(" ");
        int n = Integer.parseInt(splLine[0]);
        int k = Integer.parseInt(splLine[1]);
        int[] cats = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cats);

        int left = 0;
        int right = cats.length-1;
        while(left < right){
            while(right > left){
                if(cats[left] + cats[right] <= k){
                    result++;
                    right--;
                    break;
                }
                right--;
            }

            left++;
        }
        System.out.println(result);
    }
}
