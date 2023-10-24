import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        
        long sum = 0;
        long result = 0;
        for(int i = 1; i <= count; i++) sum += price * i;
        result = money - sum;
        return result > 0 ? 0 : Math.abs(result);
    }
}