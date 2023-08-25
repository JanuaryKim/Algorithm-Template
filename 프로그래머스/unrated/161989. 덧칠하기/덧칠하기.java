import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        int result = 1; //안전 지역을 첫번째 기준으로 지정하였기 때문에, 첫번째 칠해야할 구역은 자동으로 패스가 되므로 사전에 1로써 할당해줌.
        int safeAreaEnd = section[0] + m - 1; //안전 지역의 끝점만 지정을 하고 (끝점 안쪽의 구역들은 안전지역이라고 가정하고)    
        for(int i : section)
        {
            if(i > safeAreaEnd) //어차피 최초 i의 값은 최초 safeAreaEnd 안쪽으로 지정이 됨
            {
                result++;
                safeAreaEnd = i + m - 1;
            }
        }   
        return result;
    }
}