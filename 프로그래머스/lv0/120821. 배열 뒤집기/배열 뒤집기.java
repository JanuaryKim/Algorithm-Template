class Solution {
    public int[] solution(int[] num_list) {
        
        int[] result = new int[num_list.length];
        for(int i = num_list.length-1; i >= 0; i--)
        {
            result[(num_list.length-1)-i] = num_list[i];
        }
        return result;
    }
}