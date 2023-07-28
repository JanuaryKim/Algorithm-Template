class Solution {
    public int solution(int a, int b, int n) {
        
        int result = 0;
        while(n >= a)
        {
            result += b * (n / a);
            n = b * (n / a) + n % a;
        }
        return result;
    }
}