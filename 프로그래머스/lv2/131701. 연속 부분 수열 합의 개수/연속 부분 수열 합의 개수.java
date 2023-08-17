import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        int ctn = 1;
        while(ctn < elements.length)
        {
            for(int j = 0; j < elements.length; j++)
            {
                int tempSum = 0;
                for(int k = j; k < j+ctn; k++)
                {
                    tempSum += elements[k%elements.length];
                }
                set.add(tempSum);
            } 
            ctn++;
        }  
        set.add(Arrays.stream(elements).sum());
        return set.size();
    }
}