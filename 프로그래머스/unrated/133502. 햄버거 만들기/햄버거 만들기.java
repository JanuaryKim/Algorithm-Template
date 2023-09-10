import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        int result = 0;
        int[] st = new int[ingredient.length];
        int idx = 0;
        for(int i : ingredient)
        {
            st[idx++] = i;
            if(idx >= 4 && 
               st[idx - 1] == 1 && st[idx - 2] == 3 && st[idx - 3] == 2 && st[idx - 4] == 1) {
                result++;
                idx -= 4;
            }
        }
        
        return result;
    }
}