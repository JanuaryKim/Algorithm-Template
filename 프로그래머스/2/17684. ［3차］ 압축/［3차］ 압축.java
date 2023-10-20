import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> list = new ArrayList<>();
        int start = 0;
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 0; i < 26; i++){
            char c = (char)('A' + i);
            m.put(String.valueOf(c), i+1);
        }
        
        int idx = 27;
        while(start < msg.length()){
            
            String sub = "";
            Integer val = null;
            for(int i = msg.length(); i > start; i--){
                sub = msg.substring(start, i);
                val = m.get(sub);
                if(val != null){
                    start = i - 1;
                    break;
                }
            }
            System.out.println(sub);
            list.add(val);
            start++;
            
            if(start < msg.length()){
                sub += msg.charAt(start);
                m.put(sub, idx++);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}