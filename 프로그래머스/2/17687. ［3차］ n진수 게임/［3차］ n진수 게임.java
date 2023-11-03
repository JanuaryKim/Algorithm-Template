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

                char c = strCurNum.charAt(i);                
                if(turn == p){
                    sb.append(c);
                    if(sb.length() == t) //이미 구할 갯수를 다 구했는데도 for문의 반복으로 인해 추가될 경우 대비, 중복 코드 발생
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