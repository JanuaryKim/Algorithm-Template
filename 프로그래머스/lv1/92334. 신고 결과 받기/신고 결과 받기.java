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

        
        // 레포트를 순회
        //  2번째 닉네임을 키값으로 하여 신고 횟수 증가
        //  2번재 닉네임을 키값으로 하여 리스트에 신고자 닉네임 저장
        
        // 신고 된 닉네임 맵 키값 순회
        //  값이 k 이상인 키값의 리스트들을 순회하여 해당 닉네임의 통보 횟수를 증가
        
    }
}