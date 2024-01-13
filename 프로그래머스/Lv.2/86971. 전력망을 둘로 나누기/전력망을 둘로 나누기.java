import java.util.*;

class Solution {
    boolean[][] map;
    boolean[] visited;
        
    public int solution(int n, int[][] wires) {
        int result = Integer.MAX_VALUE;
        map = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        
        //초기화
        for(int i = 0; i < wires.length; i++){
            int[] wire = wires[i];
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
        }
        
        List<Integer> list = new ArrayList<>();
        //하나씩 제외 반복
        for(int i = 0; i < wires.length; i++){
            int[] wire = wires[i];
            map[wire[0]][wire[1]] = false;
            map[wire[1]][wire[0]] = false;
            
            for(int j = 1; j < map.length; j++){
                if(!visited[j]){
                    visited[j] = true;
                    int ctn = search(1,j);
                    list.add(ctn);
                }
            }
            int diff = Math.abs(list.get(0) - list.get(1));
            if(diff < result){
                result = diff;
            }
            
            //초기화
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
            for(int j = 1; j < visited.length; j++){
                visited[j] = false;
            }
            list.clear();
        }
        return result;
    }
    
    private int search(int ctn, int num){
        
        for(int i = 1; i < map[num].length; i++){
            if(map[num][i] == true && !visited[i])
            {
                visited[i] = true;
                ctn = search(ctn + 1, i);
            }
        }        
        return ctn;
    }
}