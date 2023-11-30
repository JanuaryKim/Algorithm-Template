import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        int result = 0;
        String strK = Integer.toString(n,k);
        String temp = "";
        for(int i = 0; i < strK.length(); i++){
            char c = strK.charAt(i);
            if(c == '0'){              
                if(!temp.equals("")){
                    long iValue = Long.parseLong(temp);
                    if(checkSosoo(iValue)) result++;   
                }             
                temp = "";
            }
            else{
                temp += c;
            }
        }
        
        if(!temp.equals("")){
            long iValue = Long.parseLong(temp);
            if(checkSosoo(iValue)) result++; 
        }
        return result;
    }
    
    private boolean checkSosoo(long value){
        
        if(value == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(value); i++){
            if(value % i == 0)
                return false;
        }
        return true;
    }
}