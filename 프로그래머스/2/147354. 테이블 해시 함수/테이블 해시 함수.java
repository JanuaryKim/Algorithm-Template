import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int result = 0;
    
        Arrays.sort(data, (a1, a2) -> {
            int tempResult = a1[col-1] - a2[col-1];
            return tempResult != 0 ? tempResult : a2[0] - a1[0];
        });
        
        for(int i = row_begin-1; i <= row_end-1; i++){
            int sum = 0;
            for(int j = 0; j < data[i].length; j++){
                sum += data[i][j] % (i+1);
            }
            result ^= sum;
        }
        
        return result;
    }
}