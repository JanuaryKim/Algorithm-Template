import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] result = new int[targets.length];
        for(int i = 0; i < targets.length; i++)
        {
            String tStr = targets[i];
            for(int j = 0; j < tStr.length(); j++)
            {
                char curC = tStr.charAt(j);
                int keyCtn = Integer.MAX_VALUE;
                for(String key : keymap){
                    int idx = key.indexOf(curC);
                    
                    if(idx != -1 && keyCtn > idx)
                        keyCtn = idx+1;
                }

                if(keyCtn == Integer.MAX_VALUE) {
                    result[i] = -1;
                    break;
                }
                        
                
                result[i]+=keyCtn;
            }
        }
        return result;
    }
}