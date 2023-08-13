import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int result = 0;
        while(n > 0)
        {
            if(n % 2 == 0) //순간 이동으로 올 수 있는 위치라면
            {
                n /= 2;
            }
            else //순간 이동으로 올 수 없는 위치라면
            {
                n--;
                result++;
            }
        }
        return result;
    }
}