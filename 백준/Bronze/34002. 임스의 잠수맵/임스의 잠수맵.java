import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strABC = br.readLine().split(" ");
        int A = Integer.parseInt(strABC[0]);
        int B = Integer.parseInt(strABC[1]);
        int C = Integer.parseInt(strABC[2]);
        String[] strSV = br.readLine().split(" ");
        int S = Integer.parseInt(strSV[0]);
        int V = Integer.parseInt(strSV[1]);
        int L = Integer.parseInt(br.readLine());
        int accumExp = 0;
        int needExp = (250 - L) * 100;
        
        while(true){

            for(int i = 0; i < V; i++){
                int m = 0;
                while(m < 30) {
                    if(accumExp >= needExp) break;
                    m++;
                    accumExp += C;
                    result++;
                }
            }
            if(accumExp >= needExp) break;

            for(int i = 0; i < S; i++){
                int m = 0;
                while(m < 30) {
                    if(accumExp >= needExp) break;
                    m++;
                    accumExp += B;
                    result++;
                }
            }
            if(accumExp >= needExp) break;

            while(accumExp < needExp) {
                accumExp += A;
                result++;
            }
            break;
        }

        System.out.println(result);
    }

}
