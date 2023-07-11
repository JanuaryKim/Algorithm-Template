import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];


        for(int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(stringNumbers, (s1, s2) -> {

            int sum1 = Integer.parseInt(s1 + s2);
            int sum2 = Integer.parseInt(s2 + s1);
            if(sum1 > sum2)
                return -1;
            else if(sum1 < sum2)
                return 1;
            else
                return 0;
        });

        if(stringNumbers[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stringNumbers.length; i++)
        {
            sb.append(stringNumbers[i]);
        }
        return sb.toString();
    }
}