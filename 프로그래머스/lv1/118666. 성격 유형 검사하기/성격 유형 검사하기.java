import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < survey.length; i++)
        {
            String[] splStr = survey[i].split("");
            int score = choices[i];
            int realScore = 0;
            
            if(score == 4)
                continue;
            if(score > 4){
                realScore = score - 4;
                map.put(splStr[1], map.getOrDefault(splStr[1], 0) + realScore);
            }
            else{
                realScore = 4 - score;
                map.put(splStr[0], map.getOrDefault(splStr[0], 0) + realScore);
            }
        }
        
        if(map.getOrDefault("R", 0) < map.getOrDefault("T", 0))
            sb.append("T");
        else
            sb.append("R");
        
        if(map.getOrDefault("C", 0) < map.getOrDefault("F", 0))
            sb.append("F");
        else
            sb.append("C");
        
        if(map.getOrDefault("J", 0) < map.getOrDefault("M", 0))
            sb.append("M");
        else
            sb.append("J");
        
        if(map.getOrDefault("A", 0) < map.getOrDefault("N", 0))
            sb.append("N");
        else
            sb.append("A");
        
        return sb.toString();
    

    }
}