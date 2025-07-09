import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strNMK = br.readLine().split(" ");

        int n = Integer.parseInt(strNMK[0]);
        int m = Integer.parseInt(strNMK[1]);
        int k = Integer.parseInt(strNMK[2]);

        int sum = 0;
        int brokenTime = 0;
        boolean find = false;
        for(int i = 0; i < m; i++){
            String[] strTR = br.readLine().split(" ");
            int t = Integer.parseInt(strTR[0]);
            int r = Integer.parseInt(strTR[1]);
            sum += r;
            if(!find && sum > k) {
                brokenTime = i + 1;
                find = true;
            }
        }

        if(brokenTime != 0)
            System.out.println(brokenTime + " " + 1);
        else
            System.out.println("-1");
    }
}
