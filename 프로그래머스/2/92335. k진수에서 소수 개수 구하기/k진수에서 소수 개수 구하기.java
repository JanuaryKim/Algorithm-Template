import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int result = 0;
        String strN = Integer.toString(n,k);
        String[] splN = strN.split("0");
        for(String s : splN){
            if(!s.equals(""))
                if(checkSosoo(Long.parseLong(s))) result++;    
        }
        return result;
    }
    
    private  boolean checkSosoo(long value) {
        if(value == 1)
            return false;
        long end = (long)Math.sqrt(value);
        for(int i = 2; i <= end; i++){
            if(value % i == 0)
                return false;
        }
        return true;
    }
}
