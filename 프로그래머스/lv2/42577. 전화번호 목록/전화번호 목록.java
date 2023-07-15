import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Map<String, String> map = new HashMap<>();
        for(String pn : phoneBook)
        {
            map.put(pn, "prefix");
        }
        
        for(int i = 0; i < phoneBook.length; i++)
        {
            String curNum = phoneBook[i];
            
            for(int j = 1; j < curNum.length(); j++)
            {
                String splStr = curNum.substring(0, j);
                
                if(map.get(splStr) != null) {
                    return false;
                }
            }
        }
        
        return true;
    }
}