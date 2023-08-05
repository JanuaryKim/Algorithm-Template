import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        Map<Integer, Integer[]> map = new HashMap<>();
        Integer[] clp = new Integer[]{3,0};
        Integer[] crp = new Integer[]{3,2};
        
        int dialNum = 1;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                map.put(dialNum++, new Integer[]{i,j});
            }
        }
        map.put(0, new Integer[]{3,1});
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++)
        {
            int cn = numbers[i];
            Integer[] pos = map.get(cn);
            if(cn == 1 || cn == 4 || cn == 7)
            {
                clp = map.get(cn);
                sb.append("L");
            }
            else if(cn == 3 || cn == 6 || cn == 9) 
            {
                crp = map.get(cn);
                sb.append("R");
            }
            else
            {
                int diffL = Math.abs(clp[0] - pos[0]) + Math.abs(clp[1] - pos[1]);
                int diffR = Math.abs(crp[0] - pos[0]) + Math.abs(crp[1] - pos[1]); 
                
                if(diffL > diffR)
                {
                    crp = map.get(cn);
                    sb.append("R");
                }
                else if(diffL < diffR)
                {
                    clp = map.get(cn);
                    sb.append("L");
                }
                else
                {
                    String f = hand.equals("right") ? "R" : "L";
                    
                    if(f.equals("R")) {
                        crp = map.get(cn);
                    }
                    else { 
                        clp = map.get(cn);
                    }
                    sb.append(f);
                }
            }
        }
        
        return sb.toString();
    }
}