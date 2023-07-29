import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {wallpaper.length,wallpaper[0].length(), 0,0};
        
        for(int i = 0; i < wallpaper.length; i++)
        {
            String line = wallpaper[i];
            for(int j = 0; j < line.length(); j++)
            {
                char c = line.charAt(j);
                if(c == '#')
                {
                    if(answer[0] > i)
                        answer[0] = i;
                    if(answer[1] > j)
                        answer[1] = j;
                    if(answer[2] < i + 1)
                        answer[2] = i + 1;
                    if(answer[3] < j + 1)
                        answer[3] = j + 1;
                }
            }
        }
        
        return answer;
    }
}
