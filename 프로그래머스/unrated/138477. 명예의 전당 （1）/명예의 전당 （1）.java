import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < score.length; i++)
        {
            list.add(score[i]);
            list.sort((i1,i2) -> i2 - i1);
            if(list.size() < k)
                answer[i] = list.get(list.size()-1);
            else
                answer[i] = list.get(k-1);
        }
        
        
        return answer;
    }
}