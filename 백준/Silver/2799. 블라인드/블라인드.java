import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] splStrInput = bf.readLine().split(" ");
        int m = Integer.parseInt(splStrInput[0]);
        int n = Integer.parseInt(splStrInput[1]);
        int[] result = new int[5];

        String[] floor = new String[5];

        for(int i = 0; i < m; i++){ //층수별
            for(int j = 0; j < 5; j++){ //층당 5줄 입력 받음
                floor[j] = bf.readLine();
            }
            for(int j = 0; j < n; j++) //창문 갯수만큼
            {
                if(
                        floor[1].charAt((j * 5) + 1) == '*' && floor[2].charAt((j * 5) + 1) == '*'
                        && floor[3].charAt((j * 5) + 1) == '*' && floor[4].charAt((j * 5) + 1) == '*'){
                    result[4]++;
                }
                else if(
                        floor[1].charAt((j * 5) + 1) == '*' && floor[2].charAt((j * 5) + 1) == '*'
                        && floor[3].charAt((j * 5) + 1) == '*') {
                    result[3]++;
                }
                else if(
                        floor[1].charAt((j * 5) + 1) == '*' && floor[2].charAt((j * 5) + 1) == '*'){
                    result[2]++;
                }
                else if(
                        floor[1].charAt((j * 5) + 1) == '*') {
                    result[1]++;
                }
                else {
                    result[0]++;
                }
            }
        }

        bf.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 5; i++){
            sb.append(result[i]);
            if(i != 4) sb.append(" ");
        }
        System.out.println(sb);
    }
}
