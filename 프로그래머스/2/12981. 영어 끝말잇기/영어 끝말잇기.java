import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] result = {0, 0};
        Map<String, Boolean> map = new HashMap<>();
        char preLastC = words[0].charAt(words[0].length() - 1);
        int num = 2;
        int turn = 1;
        map.put(words[0], true);
        
        for(int i = 1; i < words.length; i++){
            String curVoca = words[i];
            
            if(map.get(curVoca) != null ? true : false) { // 중복 단어인지 체크
                result[0] = num;
                result[1] = turn;
                break;
            }   
            
            if(curVoca.charAt(0) != preLastC) { // 끝말 체크
                result[0] = num;
                result[1] = turn;
                break;
            }      
    
            if((i + 1) % n == 0 ? true : false){ // 턴 횟수 증가
                turn++;
            }
            num++;
            if(num > n) num = 1;
            
            map.put(curVoca, true);
            preLastC = curVoca.charAt(curVoca.length() - 1);
        }        
        return result;
    }
}