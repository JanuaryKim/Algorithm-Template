import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase();
        String match = "[^a-z0-9\\-\\_\\.]";
        new_id = new_id.replaceAll(match,"");
        match = "\\.{2,}";
        new_id = new_id.replaceAll(match,".");

        if(new_id.length() >= 2) 
        {
            if(new_id.charAt(0) == '.')
                new_id = new_id.substring(1,new_id.length());
            if(new_id.charAt(new_id.length() - 1) == '.')
                new_id = new_id.substring(0, new_id.length()-1);
        }
        else if(new_id.length() >= 1)
        {
            if(new_id.charAt(0) == '.')
                new_id = new_id.substring(1,new_id.length());
        }

        if(new_id.equals(""))
            new_id = "a";
        
        if(new_id.length() >= 16)
            new_id = new_id.substring(0,15);
        
        if(new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0, new_id.length()-1);
        
        if(new_id.length() <= 2)
        {
            String lastStr = String.valueOf(new_id.charAt(new_id.length()-1));
            
            while(new_id.length() < 3)
            {
                new_id = new_id + lastStr;
            }
        }
        
        return new_id;
        
    }
}