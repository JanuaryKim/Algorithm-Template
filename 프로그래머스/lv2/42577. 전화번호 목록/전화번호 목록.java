import java.util.*;

// 핵심은 번호 하나를 고른 상태에서 
// 고른 번호가 접두어로 존재하는지 반복문으로 검사하는 것이 아니라!
// 고른 번호를 substring으로 하나 하나 떼어내며 map에 존재하는지 확인하는 것이다. (같은 번호는 없으므로 전체 번호의 -1 길이 까지만 떼어냄)

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