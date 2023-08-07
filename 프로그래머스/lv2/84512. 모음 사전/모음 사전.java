import java.util.*;
class Solution {
    
    List<String> list = new ArrayList<>();
    String[] chars = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        
        for(int i = 1; i < 6; i++)
        {
            dfs(i, "");
        }
        
        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
    
    private void dfs(int leng, String curStr)
    {
        if(curStr.length() == leng)
        {
            list.add(curStr);
            return;
        }
        
        for(int idx = 0; idx < chars.length; idx++)
        {
            dfs(leng, curStr + chars[idx]);
        }
    }
}