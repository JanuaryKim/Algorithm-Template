class Solution {
    public int solution(int n) {
        int result = 0;
        String str = String.valueOf(n);
        for(int i = 0; i < str.length(); i++)
        {
            result += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return result;
    }
}