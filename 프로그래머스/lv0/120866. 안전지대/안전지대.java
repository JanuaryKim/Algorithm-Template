import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = board.length * board[0].length;
        Set<String> set = new HashSet<>();
        
        int[] dy = new int[]{-1,-1,-1,0,1,1,1,0};
        int[] dx = new int[]{-1,0,1,1,1,0,-1,-1};
        
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == 1)
                {
                    set.add(i + "," + j);
                    for(int z = 0; z < dx.length; z++)
                    {
                        int nR = i + dy[z];
                        int nC = j + dx[z];
                        
                        if(nR >= 0 && nR < board.length && nC >= 0 && nC < board[0].length) {
                            set.add(nR + "," + nC);
                        }
                    }
                }
            }
        }
        // 3,2
        
        // 2,1
        // 2,2 /
        // 2,3 /
        // 3,3
        // 4,3
        // 4,2
        // 4,1
        // 3,1
    
        
        
        return answer - set.size();
    }
}