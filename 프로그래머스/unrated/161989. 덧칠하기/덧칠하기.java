import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        int result = 1; 
        int safeAreaEnd = section[0] + m - 1;
        for(int i : section)
        {
            if(i > safeAreaEnd)
            {
                result++;
                safeAreaEnd = i + m - 1;
            }
        }   
        return result;
    }
}