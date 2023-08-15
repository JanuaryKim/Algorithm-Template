class Solution {
    public int solution(int n) {
        
        int result = n + 1;
        int oneCtn = check(n);
        while(true){
            if(oneCtn == check(result))
                break;
            result++;
        }
        
        return result;
    }
    
    private int check(int n) {
        
        int ctn = 0;
        while(true){
            
            int rest = n % 2;
            if(rest == 1)
                ctn++;
            n /= 2;
            if(n == 0)
                break;
            else if(n == 1)
            {
                ctn++;
                break;
            }
        }
        
        return ctn;
    }
}