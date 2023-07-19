class Solution {
    public int solution(int hp) {
        int[] attack = new int[]{5,3,1};
        int result = 0;
        
        for(int a : attack)
        {
            result += hp / a;
            hp %= a;
        }
        return result;
    }
}