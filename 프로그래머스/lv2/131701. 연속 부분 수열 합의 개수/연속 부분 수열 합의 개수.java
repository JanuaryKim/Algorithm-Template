import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        int ctn = 1;
        while(ctn < elements.length) //몇개의 연속된 요소를 더할것인지
        {
            for(int j = 0; j < elements.length; j++) //몇번째 요소에서 부터 연속 요소를 찾을 것인지
            {
                int tempSum = 0;
                for(int k = j; k < j+ctn; k++) //j번째에서 연속된 요소들을 더해줌.
                {
                    tempSum += elements[k%elements.length]; //k의 범위가 배열의 크기보다 벗어나게 되지만, k % elements.length 로 인해 순회 참조가 가능
                }
                set.add(tempSum);
            } 
            ctn++;
        }  
        set.add(Arrays.stream(elements).sum()); //마지막 요소 갯수만큼의 합은 연속 순서와는 상관없이 모두 동일 하기 때문에 전체 더하기
        return set.size();
    }
}