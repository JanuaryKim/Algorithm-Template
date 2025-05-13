import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<Integer, String> numMap = new HashMap<>();
        numMap.put(0, "zero");
        numMap.put(1, "one");
        numMap.put(2, "two");
        numMap.put(3, "three");
        numMap.put(4, "four");
        numMap.put(5, "five");
        numMap.put(6, "six");
        numMap.put(7, "seven");
        numMap.put(8, "eight");
        numMap.put(9, "nine");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = bf.readLine().split(" ");
        Map<String, Integer> map = new HashMap<>(); //숫자 텍스트, 숫자

        int n = Integer.parseInt(inputStr[0]);
        int m = Integer.parseInt(inputStr[1]);

        for(int i = n; i <= m; i++){
            String strNum = String.valueOf(i);
            String[] splStrNum = strNum.split("");
            String numSumStr = "";
            for(int j = 0; j < splStrNum.length; j++){
                int num = Integer.parseInt(splStrNum[j]);
                numSumStr += numMap.get(num);
            }
            map.put(numSumStr, i);
        }

        List<String> keyList = new ArrayList<>(map.keySet());

        Collections.sort(keyList);

        for(int i = 0; i < keyList.size(); i++){

            String numStr = keyList.get(i);
            int num = map.get(numStr);
            System.out.print(num + " ");
            if((i+1) % 10 == 0) System.out.println();
        }

    }
}
