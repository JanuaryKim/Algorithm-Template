class Solution {
    public String solution(String my_string) {
    
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < my_string.length(); i++)
        {
            char c = my_string.charAt(i);
             
            if(c >= 'a' && c <= 'z')
                c = (char)((int)c - 32);
            else
                c = (char)((int)c + 32);
            
            sb.append(String.valueOf(c));
        }

        return sb.toString();
    }
}