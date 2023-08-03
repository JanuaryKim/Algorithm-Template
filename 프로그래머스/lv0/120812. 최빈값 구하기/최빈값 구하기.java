import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        int[] arr = new int [1000];
        int maxNum = 0;
        int repeatCtn = 0;
        boolean isEquals = false;
        for(int i = 0; i < array.length; i++)
            arr[array[i]]++;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > repeatCtn)
            {
                maxNum = i;
                repeatCtn = arr[i];
                isEquals = false;
            }
            else if(arr[i] == repeatCtn)
            {
                isEquals = true;
            }
        }
        return isEquals ? -1 : maxNum;
    }
}