class Solution {
    public int solution(int n, int k) {
        
        int saledDrinkCtn = k - (n / 10);
        
        return (n * 12000) + (saledDrinkCtn * 2000);
    }
}