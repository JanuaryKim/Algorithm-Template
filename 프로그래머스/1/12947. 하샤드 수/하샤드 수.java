import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        String[] strArr = String.valueOf(x).split("");
        for(int i = 0; i < strArr.length; i++){
            sum += Integer.parseInt(strArr[i]);
        }
        
        return x % sum == 0 ? true : false;
    }
}