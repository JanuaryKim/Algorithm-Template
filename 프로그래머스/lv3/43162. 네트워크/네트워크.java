import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {       
        int result = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                result++;
                dfs(computers, i);
            }
        }
        return result;
    }   
    private void dfs(int[][] coms, int comIdx)
    {
        visited[comIdx] = true;
        for(int i = 0; i < coms[comIdx].length; i++)
        {
            if(i == comIdx) continue;
            if(coms[comIdx][i] == 1 && !visited[i])
                dfs(coms, i);
        }
        
    }
}