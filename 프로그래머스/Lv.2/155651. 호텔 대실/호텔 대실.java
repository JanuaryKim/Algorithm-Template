import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int result = 0;
        List<Integer[]> minuteTime = new ArrayList<>();
        
        for(int i = 0; i < book_time.length; i++){
            String[] book = book_time[i];
            
            //시작 시간
            String[] hm = book[0].split(":");
            int hour = Integer.parseInt(hm[0]);
            int minute = Integer.parseInt(hm[1]);
            int startTotal = (hour * 60) + minute;            
            
            //종료 시간
            hm = book[1].split(":");
            hour = Integer.parseInt(hm[0]);
            minute = Integer.parseInt(hm[1]);
            int endTotal = (hour * 60) + minute;
            
            Integer[] time = new Integer[]{startTotal,endTotal};
            minuteTime.add(time);
        }
        
        Collections.sort(minuteTime, (b1, b2) -> b1[0] - b2[0]);
        
        int nextBookTime = 0;
        
        while(minuteTime.size() > 0) {
            boolean find = false;

            for(int i = 0; i < minuteTime.size(); i++){
                Integer[] book = minuteTime.get(i);
                
                if(nextBookTime <= book[0]){                  
                    find = true;
                    nextBookTime = book[1] + 10;
                    minuteTime.remove(i);
                    break;
                }               
            }
            if(find){
                if(minuteTime.size() == 0)
                    result++;
                continue;
            }
            else{
                result++;
                nextBookTime = 0;
            }            
        } 
        return result;
    }
}