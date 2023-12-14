import java.util.*;

class Solution {
    int result = 0;
    char[][] map;
    List<Integer[]> list = new ArrayList<>();
    int[][] dir = {{0,0}, {1,0}, {0,1}, {1,1}};
    public int solution(int m, int n, String[] board) {
        
        map = init(m, n, board);
                    
     

        while(checkBlock()){
            clearBlock();    
            downBlock();
        }
        
        return result;
    }
    
    private char[][] init(int m, int n, String[] board){
        char[][] result = new char[m][n];
        for(int i = 0; i < board.length; i++){
            String line = board[i];
            for(int j = 0; j < line.length(); j++){
                result[i][j] = line.charAt(j);
            }
        }
        return result;
    }
    
    private boolean checkBlock(){     
      
        boolean result = false;
        for(int i = 0; i < map.length-1; i++){
            for(int j = 0; j < map[i].length-1; j++){
                char c = map[i][j];
                if(c == ' ') continue; 
                if(c == map[i][j+1] && c == map[i+1][j] && c ==map[i+1][j+1]){
                    list.add(new Integer[]{i,j});                   
                    result = true;
                } 
            }
        }
        return result;
    }
    
    
    private void clearBlock(){
        
        for(Integer[] pos : list){
            for(int i = 0; i < dir.length; i++){
                int row = pos[0] + dir[i][0];
                int col = pos[1] + dir[i][1];
                if(map[row][col] != ' '){
                    result++;
                    map[row][col] = ' ';
                }
            }
        }
        list.clear();
    }
    
    private void downBlock(){
        int[] ctns = new int[map[0].length];
        for(int i = map.length-1; i >= 0; i--){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == ' '){
                    ctns[j]++;
                }
                else{
                    if(ctns[j] != 0){
                        map[i+ctns[j]][j] = map[i][j];
                        map[i][j] = ' ';
                    }
                }
                
            }
        }
    }
}