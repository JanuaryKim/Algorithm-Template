import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//14468
public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        int[][] cow = new int[26][2];

        for(int i = 0; i < 26; i++){
            Arrays.fill(cow[i], -1);
        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            int index = c - 'A';
            if(cow[index][0] == -1)
                cow[index][0] = i;
            else
                cow[index][1] = i;
        }

        for(int i = 0; i < cow.length; i++){
            for(int j = 0; j < cow.length; j++){
                if(cow[j][0] > cow[i][0] && cow[j][0] < cow[i][1] && cow[j][1] > cow[i][0] && cow[j][1] > cow[i][1]){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
