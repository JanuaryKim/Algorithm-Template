class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        
        int sum = 0;
        for(int i = 0; i < absolutes.length; i++)
        {
            String str = String.valueOf(absolutes[i]);
            if(signs[i] == false)
                str = "-" + str;
            
            sum += Integer.parseInt(str);
        }
        
        return sum;
    }
}