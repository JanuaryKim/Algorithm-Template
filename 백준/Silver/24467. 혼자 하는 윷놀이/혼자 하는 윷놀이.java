import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int line = 1;
    static int currentPos = 0;

    public static void main(String[] args) throws IOException {
        //도,개,걸,윷,모 판정 로직
        //다음 목표 위치 계산 변수
        //도착 여부 확인 로직
        String result = "LOSE";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int totalCnt = 1;
        boolean oneMore = false;
        for(int i = 0; i < 10; i++){

            oneMore = false;
            if(totalCnt > 50) break;

            String input = br.readLine();

            totalCnt++;

            //모
            if ("1111".equals(input)) {
                currentPos += 5;
                oneMore = true;
            }
            //윷
            else if("0000".equals(input)){
                currentPos += 4;
                oneMore = true;
            }
            else{
                int yootCnt = getYoot(input);
                currentPos += yootCnt;
            }

            if(checkGoal()){
                result = "WIN";
            }

            organizePosition();

            if(oneMore) i--;
        }

        System.out.println(result);
    }

    public static void organizePosition(){

        if(line == 1 && currentPos == 5) { // 1 -> 5
            line = 5;
            currentPos = 0;
        }
        else if(line == 5 && currentPos == 3) { // 5 -> 8
            line = 8;
            currentPos = 0;
        }
        else if((line == 5 && currentPos >= 4) && (line == 5 && currentPos <= 5)){ // 5 -> 7
            line = 7;
            currentPos = currentPos - 3;
        }
        else if(line == 5 && currentPos >= 6){ // 5 -> 4
            line = 4;
            currentPos = currentPos - 3 - 3;
        }
        else if(line == 1 && currentPos > 5){ // 1 -> 2
            line = 2;
            currentPos = currentPos - 5;
        }
        else if(line == 2 && currentPos == 5){ // 2 -> 6
            line = 6;
            currentPos = 0;
        }
        else if(line == 2 && currentPos > 5){ // 2 -> 3
            line = 3;
            currentPos = currentPos - 5;
        }
        else if(line == 3 && currentPos >= 5){ // 3 -> 4
            line = 4;
            currentPos = currentPos - 5;
        }
        else if(line == 6 && currentPos >= 3){ // 6 -> 8
            line = 8;
            currentPos = currentPos - 3;
        }
        else if(line == 7 && currentPos >= 3){
            line = 4;
            currentPos = currentPos - 3;
        }

    }

    public static boolean checkGoal(){

        boolean result = false;

        if(line == 4 && currentPos >= 6) result = true;

        if(line == 8 && currentPos >= 4) result = true;

        if(line == 6 && currentPos >= 7) result = true;
        return result;
    }

    public static int getYoot(String input){
        int result = 0;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '0') result++;
        }
        return result;
    }
}
