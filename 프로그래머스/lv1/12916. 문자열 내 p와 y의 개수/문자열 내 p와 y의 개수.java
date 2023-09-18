class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int sCtn = 0;
        int yCtn = 0;
        s = s.toUpperCase();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'P')
                sCtn++;
            else if(s.charAt(i) == 'Y')
                yCtn++;
        }

        if(sCtn == yCtn)
            return true;
        else
            return false;
    }
}