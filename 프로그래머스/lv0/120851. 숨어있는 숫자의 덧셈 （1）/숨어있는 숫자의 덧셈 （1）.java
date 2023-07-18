class Solution {
    public int solution(String my_string) {
        
        int result = 0;
        
        for(int i = 0; i < my_string.length(); i++)
        {
            char c = my_string.charAt(i);
            int charAsc = (int)c;

            if(49 <= charAsc && charAsc <= 57)
            {
                result += Integer.parseInt(String.valueOf(c));
            }
        }
        
        return result;
    }
}