class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int result[] = new int[2];
        int existsNum = 0;
        int misteryNum = 0;
        for(int i = 0; i < lottos.length; i++)
        {
            int myNum = lottos[i];
            if(myNum == 0)
            {
                misteryNum++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++)
            {
                if(myNum == win_nums[j]) {
                    existsNum++;
                    break;
                }
            }
        }
        
        
        int possibleNum = existsNum + misteryNum;
        
        if(possibleNum == 6)
            result[0] = 1;
        else if(possibleNum == 5)
            result[0] = 2;
        else if(possibleNum == 4)
            result[0] = 3;
        else if(possibleNum == 3)
            result[0] = 4;
        else if(possibleNum == 2)
            result[0] = 5;
        else
            result[0] = 6;
        
        if(existsNum == 6)
            result[1] = 1;
        else if(existsNum == 5)
            result[1] = 2;
        else if(existsNum == 4)
            result[1] = 3;
        else if(existsNum == 3)
            result[1] = 4;
        else if(existsNum == 2)
            result[1] = 5;
        else
            result[1] = 6;
        
        
        return result;
        
    }
}