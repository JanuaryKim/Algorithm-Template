import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        Deque<String> dq = new LinkedList<>();
        int answer = 0;
        for(String city : cities)
        {
            String lowerStrCity = city.toLowerCase();
            
            if(cacheSize == 0)
            {
                answer += 5;
                continue;
            }
            
            if(dq.contains(lowerStrCity))
            {
                dq.remove(lowerStrCity);
                dq.addFirst(lowerStrCity);
                answer += 1;
            }
            else
            {
                if(dq.size() >= cacheSize)
                    dq.removeLast();
                
                dq.addFirst(lowerStrCity);
                answer += 5;
            }
        }
        
        return answer;
    }
}