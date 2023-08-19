import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {       
        int result = 0;
        boolean[] visited = new boolean[computers.length];
        Queue<Integer> q = new LinkedList<>();
         
        for(int i = 0; i < computers.length; i++)
        {

            if(visited[i]) continue;

            result++;
            q.offer(i);
            visited[i] = true;
            while(q.size() > 0)
            {
                
                int com = q.poll();
                for(int j = 0; j < computers[i].length; j++)
                {
                    if(i == j) continue;
                    if(!visited[j] && computers[com][j] == 1){
                        q.offer(j); 
                        visited[j] = true;
                    }
                }
            }            
        }      
        return result;
    }   
}