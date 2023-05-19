import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> rankMap = new HashMap<>();
        
        for(int i = 0; i < players.length; i++)
        {
            nameMap.put(players[i], i+1);
            rankMap.put(i+1, players[i]);
        }
        
        for(int i = 0; i < callings.length; i++)
        {
            String callingName = callings[i];
            Integer currentRank = nameMap.get(callingName);
            
            String frontName = rankMap.get(currentRank-1);
            
            rankMap.put(currentRank-1, callingName);
            rankMap.put(currentRank, frontName);
            
            nameMap.put(callingName, currentRank-1);
            nameMap.put(frontName, currentRank);
        }
        
        String[] result = new String[players.length];
        for(int i = 1; i <= rankMap.size(); i++)
        {
            result[i-1] = rankMap.get(i);
        }
        
        return result;
    }
}