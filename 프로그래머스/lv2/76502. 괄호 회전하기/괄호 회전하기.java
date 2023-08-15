import java.util.*;

class Solution {
    public int solution(String s) {
        
        int result = 0;
        Deque<String> dq = new LinkedList<>();
        String[] strArr = s.split("");
        for(int i = 0; i < strArr.length; i++)
            dq.add(strArr[i]);
        
        for(int i = 0; i < s.length() -1; i++)
        {
            if(check(dq))
                result++;
            String str = dq.pollFirst();
            dq.offerLast(str);
        }
        
        return result;
    }
    
    private boolean check(Deque<String> dq)
    {
        Stack<String> st = new Stack<>();
        
        for(String str : dq)
        {
            if(str.equals("["))
                st.push("[");
            else if(str.equals("("))
                st.push("(");
            else if(str.equals("{"))
                st.push("{");
            else{
                 if(st.empty())
                    return false;
                String peek = st.peek();
               
                if(str.equals("]")) {
                    if(!peek.equals("["))
                        return false;
                    st.pop();
                }
                else if(str.equals(")")) {
                    if(!peek.equals("("))
                        return false;
                    st.pop();
                }
                else if(str.equals("}")) {
                    if(!peek.equals("{"))
                        return false;
                    st.pop();
                }
            }
        }
        
        if(st.empty())
            return true;
        else 
            return false;
    }
}