import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxContinue = 0;
        int tempContinue = 0;
        int skillCnt = 1;
        int preNum = arr[0];

        for (int i : arr) {
            if(preNum > i) {
                if(tempContinue > maxContinue) maxContinue = tempContinue;
                skillCnt++;
                tempContinue = 1;
            }
            else{
                tempContinue++;
            }
            preNum = i;
        }

        if(tempContinue > maxContinue) maxContinue = tempContinue;
        System.out.println(skillCnt + " " + maxContinue);
    }
}
