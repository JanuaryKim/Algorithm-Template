import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] strSpl = bf.readLine().split(" ");
        long haveMoney = Long.parseLong(strSpl[0]);
        long hooanPower = Long.parseLong(strSpl[1]);

        boolean check = false;
        for(int i = 0; i < n; i++){
            String[] spl = bf.readLine().split(" ");
            long price = Long.parseLong(spl[0]);
            long power = Long.parseLong(spl[1]);

            if(haveMoney >= price && power > hooanPower) {
                check = true;
            }
        }

        if(check)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
