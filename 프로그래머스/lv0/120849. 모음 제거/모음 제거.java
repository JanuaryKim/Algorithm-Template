class Solution {
    public String solution(String my_string) {
        char[] chArr = {'a','e','i','o','u'};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++)
        {
            char ch = my_string.charAt(i);
            boolean contain = false;
            for(int j = 0; j < chArr.length; j++)
            {
                if(ch == chArr[j])
                    contain = true;
            }
            if(!contain)
                sb.append(ch);
        }
        return sb.toString();
        
    }
}