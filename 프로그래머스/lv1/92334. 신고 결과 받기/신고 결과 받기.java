import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> reported = new HashMap<>();
        Map<String, List<String>> reportList = new HashMap<>();
        Map<String, Integer> receive = new HashMap<>();
        
        for(String con : report){
            
            String[] spl = con.split(" ");
            
            if(reportList.get(spl[1]) != null && reportList.get(spl[1]).contains(spl[0]))
                continue;
            
            reported.put(spl[1], reported.getOrDefault(spl[1], 0) + 1);
            List<String> rList = reportList.getOrDefault(spl[1], new ArrayList());
            rList.add(spl[0]);
            reportList.put(spl[1], rList);
        }
        
        for(String key : reported.keySet()){
            Integer ctn = reported.get(key);
            if(ctn >= k)
            {
                List<String> list = reportList.get(key);
                for(String nick : list){
                    receive.put(nick, receive.getOrDefault(nick, 0) + 1);
                }
            }
        }
        
        for(int i = 0; i < id_list.length; i++)
        {
            answer[i] = receive.getOrDefault(id_list[i], 0);
        }  
        
        return answer;  
    }
}