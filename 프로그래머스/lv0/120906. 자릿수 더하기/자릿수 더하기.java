class Solution {
    public int solution(int n) {
        int result = 0;
        String[] str = String.valueOf(n).split("");
        for(int i = 0; i < str.length; i++)
        {
            result += Integer.parseInt(str[i]);
        }
        return result;
    }
}