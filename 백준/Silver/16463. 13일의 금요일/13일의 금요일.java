import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int result = 0;
        int yo = 2;

        for(int y = 2019; y <= n; y++){
            for(int m = 1; m <= 12; m++){
                int limit = 30;
                if(m == 1) limit = 31;
                else if(m == 2) {
                    limit = 28;
                    if(y % 400 == 0) limit = 29;
                    else{
                        if(y % 100 == 0) limit = 28;
                    }
                    if(y % 100 != 0 && y % 4 == 0) limit = 29;
                }
                else if(m == 3) limit = 31;
                else if(m == 4) limit = 30;
                else if(m == 5) limit = 31;
                else if(m == 6) limit = 30;
                else if(m == 7) limit = 31;
                else if(m == 8) limit = 31;
                else if(m == 9) limit = 30;
                else if(m == 10) limit = 31;
                else if(m == 11) limit = 30;
                else if(m == 12) limit = 31;
                
                for(int d = 1; d <= limit; d++){
                    if(yo == 5 && d == 13){
                        result++;
                    }
                    if(yo == 7) yo = 1;
                    else yo++;
                }
            }
        }
        System.out.println(result);
    }
}
