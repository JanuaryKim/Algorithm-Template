import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Queue<Integer>[] qArr = new Queue[board[0].length];
        Stack<Integer> b = new Stack<>();
        
        for(int i = 0; i < board[0].length; i++)
        {
            qArr[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] != 0)
                    qArr[j].add(board[i][j]);
            }
        }
        
        for(int i = 0; i < moves.length; i++)
        {
            Integer value = qArr[moves[i]-1].poll();
            if(b.size() > 0 && b.peek().equals(value)){
                
                answer += 2;
                b.pop();
                continue;
            }
                      
            if(value != null)
                b.add(value);
        }          
        
        return answer;
    }
}