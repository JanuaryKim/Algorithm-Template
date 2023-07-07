import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int preInteger = -1;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            if(preInteger != arr[i])
            {
                list.add(arr[i]);
                preInteger = arr[i];
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}