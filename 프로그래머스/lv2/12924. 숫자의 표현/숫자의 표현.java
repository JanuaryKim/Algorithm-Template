class Solution {
    public int solution(int n) {
        
        int result = 0;
        int start = 1;
        
        while(start <= n)
        {
            int tempStart = start;
            int tempSum = 0;
            while(true)
            {
                tempSum += tempStart++;
                if(tempSum == n){
                    result++;
                    break;
                }
                else if(tempSum > n){
                    break;
                }
                
            }
            start++;
        }
        return result;
        
    }
}