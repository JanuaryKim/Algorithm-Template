import java.util.*;

class Solution
{
    public int solution(String s)
    {
        String[] spl = s.split("");
        Stack<String> stack = new Stack<>();

        for (String str : spl) {
            if (!stack.isEmpty() && stack.peek().equals(str)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}