class Solution {
    public int solution(String str1, String str2) {
        
        int leng = str1.length() - str2.length();
        for(int i = 0; i <=leng; i++)
        {
            String comStr = str1.substring(i, i + str2.length());
            if(str2.equals(comStr))
                return 1;
        }
        return 2;
    }
}