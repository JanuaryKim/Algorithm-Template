import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//24390
public class Main {
    public static void main(String[] args) throws IOException {
        //시간이 큰 버튼 순서대로 눌러야 하는지 체크하여
        //눌러야 하는 만큼 시간을 제외하고, 버튼 눌림 횟수를 증가
        //만약 분, 초가 모두 0이 되고, 조리시작 버튼이 안 눌렸을 경우 마지막에 조리시작 버튼 횟수 추가
        int result = 0;
        int[] mButtons = {10,1};
        int[] sButtons = {30, 10};
        boolean start = false;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] time = Arrays.stream(bf.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int minute = time[0];
        int second = time[1];

        int i = 0;
        while(minute > 0){
            result += minute / mButtons[i];
            minute = minute % mButtons[i++];
        }
        i = 0;
        while(second > 0){

            int addSecondButton = second / sButtons[i];
            if(i == 0 && addSecondButton > 0) start = true;
            result += addSecondButton;
            second = second % sButtons[i++];
        }

        if(!start) result++;
        System.out.println(result);
    }
}
