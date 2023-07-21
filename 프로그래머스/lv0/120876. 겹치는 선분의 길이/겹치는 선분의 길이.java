import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        
        int[] arr = new int[200];
        int result = 0;
        for(int[] a : lines)
        {
            int start = a[0] + 100;
            int end = a[1] + 100;
            
            for(int i = start; i < end; i++)
            {
                arr[i]++;
            }
        }
        
        for(int i = 0; i < arr.length; i++)
            if(arr[i] > 1)
                result++;
        
        return result;
    }
}


