import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++)
        {
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list,(i1,i2) -> i2-i1);
        
        int tempSum = 0;
        for(int i = 0; i < list.size(); i++)
        {
            tempSum += list.get(i);
            if(tempSum >= k){
                result = i+1;
                break;
            }
        }
        return result;
    }
}
