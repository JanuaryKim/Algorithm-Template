import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < array.length; i++)
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        
        int maxNum = 0;
        int repeatCtn = 0;
        boolean isEqual = false;
        for(Integer num : map.keySet())
        {
            int ctn = map.get(num);
            if(ctn > repeatCtn)
            {
                maxNum = num;
                repeatCtn = ctn;
                isEqual = false;
            }
            else if(ctn == repeatCtn)
                isEqual = true;
        }
        
        return isEqual ? -1 : maxNum;
    }
}