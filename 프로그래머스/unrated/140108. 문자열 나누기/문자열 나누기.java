class Solution {
    public int solution(String s) {
        
        int answer = 0;
        int xCtn = 0;
        int otherCtn = 0;
        char firstC = '-';
        
        for(int i = 0; i < s.length(); i ++)
        {
            char curC = s.charAt(i);
            
            if(firstC == '-') {
                firstC = curC;
                xCtn++;
                continue;
            }
            
            if(firstC == curC)
                xCtn++;
            else
                otherCtn++;
            
            if(xCtn == otherCtn)
            {
                answer++;
                firstC = '-';
                xCtn = 0;
                otherCtn = 0;
            }          
        }
        
        if(firstC != '-')
            answer++;
        
        return answer;
    }
}