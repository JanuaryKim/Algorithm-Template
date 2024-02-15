import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

//9627
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //예외적인 10의 자리 수 데이터
        String[] subTen = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        //1의 자리, 10의 자리, 100의 자리 순으로 각 문자열의 초기 데이터 넣어둠. 각 배열의 0번째 혹은 1번째 요소를 비워둔것은 
        //증가 된 수를 분할 한 뒤, 해당 수를 init 배열에서 그대로 인덱스로 사용하기 위함.
        String[][] init = { 
                {"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"},
                {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"},
                {"", "onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred","sixhundred", "sevenhundred", "eighthundred", "ninehundred"}
        };

        int n = Integer.parseInt(bf.readLine());
        if(n == 1){ // 예외처리, n이 1인 상황에서는 현재 로직상 아무것도 출력하지 못함.
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
        while(tempCharCtn < 1000){ //최대 3자리인 숫자이기 때문에, 그리고 가능한 작은 수를 찾아내야 하기 때문에 증감시키면 체크
            splNum = splitNumber(tempCharCtn);   //증감 되는 숫자를 split 하여 각자릿수로 떼어낸다.

            for(int i = 2; i >= 0; i--){ // 100의 자리, 10의 자리, 1의 자리 의 각 숫자 String을 추가 함.
                if(i == 1){ //십의 탐색시
                    if(splNum[i] == 1 && splNum[2] == 0){ //[n]10인 경우
                        sb.append(init[0][init[0].length-1]); //바로 ten 넣음
                        break;
                    }
                    else if(splNum[i] == 1){ //[n]1[n] 인 경우
                        sb.append(subTen[splNum[2]]); //subTen중에 선택,
                        break;
                    }
                }
                sb.append(init[i][splNum[2-i]]); //
            }
            
            if(oriCharCtn + sb.length() == tempCharCtn) { //추가 될 숫자 String 제외한 나머지 단어들의 총 합 + 증감 된 숫자를 표현한 문자열 길이 == 증감 된 숫자
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
