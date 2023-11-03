import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        int curNum = 0;
        int turn = 1;
        
        while(sb.length() < t){
            
            String strCurNum = Integer.toString(curNum++, n).toUpperCase();
            System.out.println(strCurNum);
            for(int i = 0; i < strCurNum.length(); i++){
                
                // [0, 1, [1, 0, [1, 1, [1, 0, 0
                char c = strCurNum.charAt(i);
                
                if(turn == p){
                    sb.append(c);
                    if(sb.length() == t)
                        break;
                }
                
                turn++;
                if(turn > m){
                    turn = 1;
                }
            }
        }
        
        return sb.toString();
    }
}