import java.util.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int[] answer = new int[2];
        int biggerD = Math.max(denom1, denom2);
        int smallerD = Math.min(denom1, denom2);
        
        int denom = 0;
        int mul = 2;
        int tempBiggerD = biggerD;
        while(true){
            
            if(tempBiggerD % smallerD == 0)
            {
                denom = tempBiggerD;
                break;
            }
            else
                tempBiggerD = biggerD * mul++;
        }
        
        answer[1] = denom;
        answer[0] = (denom / denom1) * numer1 + (denom / denom2) * numer2;
        
        System.out.println(answer[1]);
        System.out.println(answer[0]);
        
        
        for(int i = answer[1] / 2; i > 1; i--)
        {
            if(answer[0] % i == 0 && answer[1] % i == 0)
            {
                System.out.println(i);
                answer[0] /= i;
                answer[1] /= i;
            }
        }
        
        return answer;        
    }
}
