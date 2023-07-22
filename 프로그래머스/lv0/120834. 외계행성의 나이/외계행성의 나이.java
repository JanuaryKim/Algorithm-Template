class Solution {
    public String solution(int age) {
        
        String strAge = String.valueOf(age);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strAge.length(); i++)
        {
            char c = strAge.charAt(i);
            String s = String.valueOf(c);
            int in = Integer.parseInt(s);
            char tempChar = (char)((int)'a' + in);
            sb.append(tempChar);
        }
        
        return sb.toString();
    }
}