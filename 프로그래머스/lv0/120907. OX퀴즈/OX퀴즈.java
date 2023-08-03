import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        
        String[] result = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++)
        {
            String[] spl = quiz[i].split("=");
            String[] subSpl = spl[0].split(" ");
            
            int sum = Integer.parseInt(subSpl[0]);
            String s = ".";
            for(int j = 1; j < subSpl.length; j++)
            {
                String curS = subSpl[j];
                // System.out.println(curS);
                if(curS.equals("-") || curS.equals("+"))
                    s = curS;
                else
                {
                    if(s.equals("-"))
                        sum = sum - Integer.parseInt(curS);
                    else
                        sum = sum + Integer.parseInt(curS);
                }
            }
            
            if(sum == Integer.parseInt(spl[1].trim()))
                result[i] = "O";
            else
                result[i] = "X";
        }
        
        return result;
    }
}