class Solution {
    public int solution(int n) {
        
        int result = 0;
        int limit = n / 2;
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
                result++;
        }
        
        return result;
    }
}