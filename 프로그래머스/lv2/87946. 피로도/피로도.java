class Solution {
    boolean[] visited;
    int maxDungeons = 0;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return maxDungeons;
    }
    
    private void dfs(int[][] dungeons, int restHp, int dCtn)
    {
        if(dCtn > maxDungeons)
        {
            maxDungeons = dCtn;
        }
        
        for(int i = 0; i < dungeons.length; i++)
        {
            if(visited[i] == false && dungeons[i][0] <= restHp)
            {
                visited[i] = true;
                dfs(dungeons, restHp - dungeons[i][1], dCtn + 1);
                visited[i] = false;
            }
        }
    }
}