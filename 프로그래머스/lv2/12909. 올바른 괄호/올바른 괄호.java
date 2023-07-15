import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '('){
                stack.push(1);
            }
            else{
                if(stack.empty())
                    return false;
                
                stack.pop();
            }
        }
        
        if(stack.empty())
            return true;
        else
            return false;
     
    }
}