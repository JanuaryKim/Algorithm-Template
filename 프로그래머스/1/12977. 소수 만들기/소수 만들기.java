class Solution {
    public int solution(int[] nums) {
        
        int result = 0;
        for(int i = 0; i < nums.length -2; i++){
            for(int j = i + 1; j < nums.length -1; j++){
                for(int z = j + 1; z < nums.length; z++){
                    
                    int sum = nums[i] + nums[j] + nums[z];
                    if(check(sum))
                        result++;
                }
            }
        }
        
        return result;
    }
    
    private boolean check(int n){
        
        boolean result = true;
        for(int i = 2; i <= n / 2; i++)
        {
            if(n % i == 0)
                return false;
        }
        return result;
    }
}