import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        
        int ctn = 1;
        
        while(ctn <= elements.length)
        {
            for(int j = 0; j < elements.length; j++)
            {
                int idx = j;
                int tempCtn = 0;
                int tempSum = 0;
                while(tempCtn < ctn){
                    
                    tempSum += elements[idx++];
                    if(idx >= elements.length)
                    {
                        idx = 0;
                    }
                    tempCtn++;
                }
                set.add(tempSum);
            } 
            ctn++;
        }
        
        
        return set.size();
    }
}