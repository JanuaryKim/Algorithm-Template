import java.util.*;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        
        int size = num1 == 0 ? num2 + 1 : num2 - num1 + 1;
        
        int[] result = new int[size];
        
        int idx = 0;
     
        for(int i = num1; i <= num2; i++)
        {
            
            result[idx++] = numbers[i];
        }
        
        return result;
    }
}