import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strWH = br.readLine().split(" ");
        int w = Integer.parseInt(strWH[0]);
        int h = Integer.parseInt(strWH[1]);
        int line = (w + h) * 2;
        int n = Integer.parseInt(br.readLine());
        int[] spotArr = new int[n + 1];

        for(int i = 0; i <= n; i++){
            String[] inputSpot = br.readLine().split(" ");
            int side = Integer.parseInt(inputSpot[0]);
            int spot = Integer.parseInt(inputSpot[1]);
            spotArr[i] = spot;

            if(side == 2)
                spotArr[i] = w + h + (w - spotArr[i]);
            else if(side == 3)
                spotArr[i] = w + h + w + (h - spotArr[i]);
            else if(side == 4)
                spotArr[i] = w + spotArr[i];
        }

        for(int i = 0; i < n; i++){
            int dis1 = Math.abs(spotArr[n] - spotArr[i]);
            int dis2 = line - dis1;

            result += Math.min(dis1, dis2);
        }

        System.out.println(result);
    }
}