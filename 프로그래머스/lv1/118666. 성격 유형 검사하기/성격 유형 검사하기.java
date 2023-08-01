import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
       String answer = "";
        
        int score_R = 0, score_T = 0, score_C = 0, score_F = 0
          , score_J = 0, score_M = 0, score_A = 0, score_N = 0;
            
        for (int i=0; i<survey.length; i++) {
            
            String sur = survey[i];
            
            String type = sur.substring(0,1);
            if(choices[i] > 4) type = sur.substring(1,2);
            
            int score = Math.abs(choices[i] - 4);

            switch(type) {
                case "R" : score_R += score; break;
                case "T" : score_T += score; break;
                    
                case "C" : score_C += score; break;
                case "F" : score_F += score; break;
                
                case "J" : score_J += score; break;
                case "M" : score_M += score; break;
                   
                case "A" : score_A += score; break;
                case "N" : score_N += score; break;
            }   
        }
        
        String userTp1 = "R";
        String userTp2 = "C";
        String userTp3 = "J";
        String userTp4 = "A";
        
        if(score_R < score_T) userTp1 = "T";
        if(score_C < score_F) userTp2 = "F";
        if(score_J < score_M) userTp3 = "M";
        if(score_A < score_N) userTp4 = "N";
        
        return userTp1+userTp2+userTp3+userTp4;
    }
}