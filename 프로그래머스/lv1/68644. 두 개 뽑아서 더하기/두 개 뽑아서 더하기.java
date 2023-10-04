import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        SortedSet<Integer> set = new TreeSet<>();
        int[] result = {};
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){             
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        result = new int[set.size()];      
        Iterator<Integer> iter = set.iterator();
        
        int i = 0;
        while(iter.hasNext()){
            result[i++] =iter.next();
        }
        return result;
    }
}