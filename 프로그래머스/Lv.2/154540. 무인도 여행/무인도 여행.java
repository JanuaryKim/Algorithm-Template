import java.util.*;

class Solution {
    boolean[][] visited;
    int[][] map;
    List<Integer> list = new ArrayList<>();
    int[] cx = new int[]{0, 1, 0, -1}; //상우하좌
    int[] cy = new int[]{-1, 0, 1, 0}; //상우하좌
    int addDay = 0;
    public int[] solution(String[] maps) {
        
        init(maps);
        
        for(int i = 0; i < map.length ; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] != 0 && !visited[i][j]) {
                    addDay = map[i][j];
                    visited[i][j] = true;
                    dfs(i, j);
                }
                if(addDay > 0)
                    list.add(addDay);
                addDay = 0;
            }
        }
       
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        if(result.length > 0)
            Arrays.sort(result);
        else
            result = new int[]{-1};
        return result;
    }
    
    private void dfs(int y, int x){
  
        for(int i = 0; i < 4; i++){
            int nextX = x + cx[i];
            int nextY = y + cy[i];
            if(nextY < map.length && nextX < map[0].length && nextY >= 0 && nextX >= 0){
                
                if(map[nextY][nextX] != 0 && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;                    
                    addDay += map[nextY][nextX];
                    dfs(nextY, nextX);                    
                }
            }
        }
    }
    
    private void init(String[] maps){
        visited = new boolean[maps.length][maps[0].length()];
        map = new int[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            String line = maps[i];
            for(int j = 0; j < line.length(); j++){
                char c = line.charAt(j);
                if(c == 'X')
                    map[i][j] = 0;
                else
                    map[i][j] = c - '0';
            }
        }
    }
}