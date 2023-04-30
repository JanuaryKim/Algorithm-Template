import java.util.*;
class Solution {
    public long solution(long n) {
        List<Long> list = new LinkedList();
  
        while(n != 0)
        {
            list.add(n%10);
            n = n / 10;
            
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        
        for(int i = list.size()-1; i >= 0; i--)
        {
            sb.append(list.get(i));
        }
        return Long.parseLong(sb.toString());
    }
}