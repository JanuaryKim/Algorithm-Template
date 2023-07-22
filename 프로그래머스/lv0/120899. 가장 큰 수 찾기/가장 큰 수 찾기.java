import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        
        int[] result = new int[]{Integer.MIN_VALUE,0};
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > result[0]) {
                result[0] = array[i];
                result[1] = i;
            }
        }
        return result;
    }
}