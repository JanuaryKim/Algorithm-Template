import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] input = bf.readLine().split(" ");
        boolean[] desLight = new boolean[n];
        for(int i = 0; i < input.length; i++){
            if(input[i].equals("1")){
                desLight[i] = true;
            }
        }

        boolean[] light = new boolean[n];
        for(int i = 0; i < n; i++){
            if(light[i] != desLight[i]){
                int limit = Math.min(i + 3, n);
                for(int j = i; j < limit; j++){
                    light[j] = !light[j];
                }
                result++;
            }
        }
        System.out.println(result);
    }
}
