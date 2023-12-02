import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        String[] result = {};
        Map<String, String> map = new HashMap<>();
        Stack<String> st = new Stack<>();
        
        for(int i = record.length - 1; i >= 0; i--) {
            String[] splR = record[i].split(" ");
            if(splR[0].equals("Change") || splR[0].equals("Enter")) {
                String id = splR[1];
                if(map.get(id) == null) {
                    map.put(splR[1] , splR[2]);
                }
            }
            
            if(splR[0].equals("Enter")) {
                st.push(splR[1] + ",님이 들어왔습니다.");
            }
            else if(splR[0].equals("Leave")) {
                st.push(splR[1] + ",님이 나갔습니다.");
            }
        }
        
        result = new String[st.size()];
     
        int idx = 0;
        while(st.size() > 0) {
            String message = st.pop();
            String[] splM = message.split(",");
            result[idx++] = map.get(splM[0]) + splM[1];
        }
        
        return result;
    }
}