import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

//9627
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] subTen = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String[][] init = {
                {"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"},
                {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"},
                {"", "onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred","sixhundred", "sevenhundred", "eighthundred", "ninehundred"}
        };

        int n = Integer.parseInt(bf.readLine());
        if(n == 1){
            System.out.println("four");
            return;
        }
        String[] result = new String[n];
        int oriCharCtn = 0;
        int emptyIdx = 0;
        for(int i = 0; i < n; i++){
            String sen = bf.readLine();
            if(sen.equals("$")) {
                emptyIdx = i;
                continue;
            }
            result[i] = sen;
            oriCharCtn += sen.length();
        }

        int[] splNum;
        StringBuilder sb = new StringBuilder();
        int tempCharCtn = oriCharCtn;
        while(tempCharCtn < 1000){
            splNum = splitNumber(tempCharCtn);

            for(int i = 2; i >= 0; i--){

                if(i == 1){
                    if(splNum[i] == 1 && splNum[2] == 0){ //[n]10인 경우
                        sb.append(init[0][init[0].length-1]); //바로 ten 넣음
                        break;
                    }
                    else if(splNum[i] == 1){ //[n]1[n] 인 경우
                        sb.append(subTen[splNum[2]]); //subTen중에 선택,
                        break;
                    }
                }
                sb.append(init[i][splNum[2-i]]);

            }

            if(oriCharCtn + sb.length() == tempCharCtn) {
                result[emptyIdx] = sb.toString();
                break;
            }
            tempCharCtn++;
            sb = new StringBuilder();
        }
        
        IntStream.range(0, result.length).forEach(idx -> {
            String res = result[idx];
            if(idx != result.length-1) res += " ";
            System.out.print(res);
        });
    }

    private static int[] splitNumber(int num){

        int idx = 2;
        int[] result = new int[3];

        while(num != 0){
            result[idx--] = num % 10;
            num /= 10;
        }
        return result;
    }
}
