import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//2503
public class Main {

    static List<Object[]> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for(int i = 0; i < n; i++){
            String[] splStr = bf.readLine().split(" ");

            int sCnt = Integer.parseInt(splStr[1]);
            int bCnt = Integer.parseInt(splStr[2]);
            int[] numbers = new int[3];
            for(int j = 0; j < 3; j++){
                numbers[j] = splStr[0].charAt(j) - '0';
            }
            list.add(new Object[]{numbers,sCnt,bCnt});
        }

        int result = 0;
        for(int i = 111; i < 1000; i++){

            if(checkRepeatOrZeroNum(i)){
                continue;
            }
            if(checkCondition(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean checkRepeatOrZeroNum(int num){

        int[] numbers= new int[10];
        boolean result = false;
        int mok = num;
        while(mok != 0){
            int n = mok % 10;
            if(numbers[n] > 0) return true;
            if(n == 0) return true;
            numbers[n]++;
            mok = mok / 10;
        }
        return result;
    }

    private static boolean checkCondition(int num){

        boolean result = true;

        int[] numArr = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        for(Object[] objs: list){

            int stCnt = (int)objs[1];
            int baCnt = (int)objs[2];
            int[] numbers = (int[])objs[0];

            int chStCnt = 0;
            int chBaCnt = 0;

            for(int i = 0; i < 3; i++){
                if(numArr[i] == numbers[i]) {
                    chStCnt++;
                }
                else{
                    for(int j = 0; j < 3; j++){
                        if(numArr[i] == numbers[j]){
                            chBaCnt++;
                        }
                    }
                }
            }

            if(chStCnt != stCnt || chBaCnt != baCnt) return false;
        }
        return result;
    }
}
