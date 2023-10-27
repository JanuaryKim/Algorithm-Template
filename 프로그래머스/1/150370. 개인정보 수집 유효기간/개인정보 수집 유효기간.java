import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        String[] spToday = today.split("\\.");
        int[] tDate = {Integer.parseInt(spToday[0]), Integer.parseInt(spToday[1]), Integer.parseInt(spToday[2])};
  
        for(String s : terms){
            String[] sp = s.split(" ");
            map.put(sp[0].charAt(0), Integer.parseInt(sp[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] sp1 = privacies[i].split(" ");           
            String[] strDate = sp1[0].split("\\."); //마침표 split시 escape           
            char t = sp1[1].charAt(0);
            int tMonth = map.get(t);
            int y = Integer.parseInt(strDate[0]);
            int m = Integer.parseInt(strDate[1]);
            int d = Integer.parseInt(strDate[2]);
            
            int[] validDate = getValidDate(y, m, d, tMonth);
            
            if(!checkDate(tDate, validDate))
                list.add(i+1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();        
    }   
    
    private int[] getValidDate(int y, int m, int d, int tMonth){
        
        int[] result = {y, m, d};
        
        while(tMonth > 0){           
            result[1]++;
            if(result[1] > 12){
                result[0]++;
                result[1] = 1;
            }
            tMonth--;
        }
        return result;
    }
    
    private boolean checkDate(int[] tDate, int[] vDate){
        
        if(tDate[0] < vDate[0])
            return true;
        else if(tDate[0] == vDate[0])
        {
            if(tDate[1] < vDate[1])
                return true;
            else if(tDate[1] == vDate[1]){
                if(tDate[2] >= vDate[2])
                    return false;
                else
                    return true;
            }
            else
                return false;
        }
        else
            return false;
    }
}