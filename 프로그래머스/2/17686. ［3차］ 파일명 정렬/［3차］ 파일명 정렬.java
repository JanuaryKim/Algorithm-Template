import java.util.*;

class Solution {
    public String[] solution(String[] files) {   
 
        Arrays.sort(files, (s1, s2) -> {
            int result = 0;
            String upperStr1 = s1.toUpperCase();
            String upperStr2 = s2.toUpperCase();
            String head1 = upperStr1.split("[0-9]")[0];                      
            String head2 = upperStr2.split("[0-9]")[0];
            result = head1.compareTo(head2);
            
            if(result == 0){
                int number1 = findNumber(upperStr1);
                int number2 = findNumber(upperStr2);
                result = number1 - number2;
            }
            System.out.println();
            return result;
        });
        
        return files;
    }
    private int findNumber(String pureStr){
        
        String strNum = "";
        boolean check = false;
        for(int i = 0; i < pureStr.length(); i++){
            char c = pureStr.charAt(i);
            if(c >= '0' && c <= '9'){
                check = true;
                int limit = pureStr.length() >= i+5 ? i+5 : pureStr.length();
                for(int j = i; j < limit; j++){
                    c = pureStr.charAt(j);
                    if(c >= '0' && c <= '9')
                        strNum += c;
                    else
                        break;
                }
            }
            if(check) break;
        }
        return Integer.parseInt(strNum);
    }
    
}