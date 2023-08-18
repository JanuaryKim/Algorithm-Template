import java.util.*;

class Solution {
    
    boolean[] visited;
    int min = Integer.MAX_VALUE;
    String[] words;
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        visited = new boolean[words.length];
        dfs(0, begin, target);
        if(min == Integer.MAX_VALUE)
            min = 0;
        return min;
    }
    
    private void dfs(int chCtn, String curStr, String target)
    {
        if(curStr.equals(target))
        {
            if(min > chCtn)
                min = chCtn;
            return;
        }
        
        for(int i = 0; i < words.length; i++)
        {
            if(!visited[i] && checkDiff(curStr, words[i]))
            {
                visited[i] = true;
                dfs(chCtn+1, words[i], target);
                visited[i] = false;
            }
        }
    }
    
    private boolean checkDiff(String a, String b)
    {
        int ctn = 0;
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) != b.charAt(i))
                ctn++;
            
            if(ctn == 2)
                return false;
        }
        return true;
    }
}