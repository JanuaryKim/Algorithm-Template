import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] splStr = s.replaceAll("\\{"," ").replaceAll("\\}", " ").trim().split(" , ");
        Arrays.sort(splStr, (s1,s2) -> s1.length() - s2.length());
        Set<Integer> set = new LinkedHashSet();
        for(String str : splStr){
            String[] spl = str.split(",");
            for(String str2 : spl){
                set.add(Integer.parseInt(str2));
            }
        }
        return set.stream().mapToInt(i->i.intValue()).toArray();
    }
}
