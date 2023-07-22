import java.util.*;
import java.util.Deque;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        Deque<Integer> dq = new LinkedList<>();
        int start = 0;
        int end = 0;
        int[] result = new int[numbers.length];
        if(direction.equals("right"))
        {
            start = 0;
            end = numbers.length-1;
        }
        else
        {
            start = 1;
            end = numbers.length;
        }
        
        for(int i = start; i < end; i++)
            dq.add(numbers[i]);
        
        if(direction.equals("right"))
            dq.addFirst(numbers[numbers.length-1]);
        else
            dq.addLast(numbers[0]);
        
        for(int i = 0; i < result.length; i++)
        {
            result[i] = dq.poll();
        }
        
        return result;
    }
}