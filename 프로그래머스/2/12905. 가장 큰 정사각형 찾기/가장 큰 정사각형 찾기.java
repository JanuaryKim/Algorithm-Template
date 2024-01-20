import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {      
        int result = 1;
        boolean isInLogic = false;
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[i].length; j++){
                if(board[i][j] == 0) continue;
                if(j >= board[i-1].length) continue; //현재 행의 열 인덱스 보다 이전 행의 길이가 짧을 경우 
                isInLogic = true;
                board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]) , board[i-1][j-1]) + 1;
                if(board[i][j] > result) result = board[i][j];
            }
        }
        if(!isInLogic){
            result = 0;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(result < board[i][j]) {
                        result = board[i][j];
                        break;
                    }
                }
            }
        }
        return result * result;
    }
}