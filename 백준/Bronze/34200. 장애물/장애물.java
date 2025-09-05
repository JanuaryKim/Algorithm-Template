import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] hurtle = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int curPos = 0;
        int hurtleIdx = 0;
        int action = 0;

        while(curPos <= hurtle[n-1]) {

            if(curPos == hurtle[hurtleIdx]) {
                action = -1;
                break;
            }
            if (curPos + 1 == hurtle[hurtleIdx]) { //다음칸이 장애물
                curPos += 2;
                hurtleIdx++;
            }
            else if(curPos + 2 == hurtle[hurtleIdx]) { //다다음칸이 장애물
                curPos += 1;
            }
            else { //이외
                curPos += 2;
            }

            action++;
        }

        System.out.println(action == 0 ? -1 : action);

    }
}
