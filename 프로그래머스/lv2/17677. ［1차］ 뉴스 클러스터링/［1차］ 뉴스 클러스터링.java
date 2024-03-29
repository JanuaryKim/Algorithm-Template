import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        List<String> list[] = new List[2]; 
        
        list[0] = new ArrayList<>();
        list[1] = new ArrayList<>();
        
        //문자열의 분리 작업. 두개씩 분리
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < str1.length(); i++)
        {
            sb.append(str1.charAt(i-1));
            sb.append(str1.charAt(i));
            list[0].add(sb.toString());
            sb = new StringBuilder();
        }
        
        for(int i = 1; i < str2.length(); i++)
        {
            sb.append(str2.charAt(i-1));
            sb.append(str2.charAt(i));
            list[1].add(sb.toString());
            sb = new StringBuilder();
        }

        //분리된 문자쌍 중 영문자가 아닌 쌍들 제거 작업. (대소문자 모두 소문자로 통일)
        for(int i = 0; i < list.length; i++)
        {
            List<String> l = list[i];
            for(int j = l.size()-1; j >= 0; j--)
            {
                String str = l.get(j);
                boolean b = true;
                for(int z = 0; z < str.length(); z++)
                {
                    char c = str.charAt(z);
                  
                    if((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')){
                        continue;
                    }
                    else
                    {
                        b = false;
                        break;
                    }
                }
                           
                if(!b){
                    l.remove(j);
                }
                else {
                    l.set(j,str.toLowerCase());
                }
            }
        }
        
        //문자쌍을 map에 저장하여 갯수 파악 
        Map<String, Integer>[] m = new Map[2];
        for(int i = 0; i < 2; i++)
        {
            m[i] = new HashMap<>();
            
            for(int j = 0; j < list[i].size(); j++)
            {
                String key = list[i].get(j);
                m[i].put(key, m[i].getOrDefault(key, 0) + 1);
            }
        }
        
        int gyoCtn = 0;
        int hapCtn = 0;
        int smallMapIdx = m[0].size() > m[1].size() ? 1 : 0;
        int bigMapIdx = 2 - smallMapIdx - 1;
        
        //교집합 갯수 구하기
        for(String key : m[smallMapIdx].keySet())
        {
            gyoCtn += Math.min(m[smallMapIdx].get(key), m[bigMapIdx].getOrDefault(key,0));
        }
        
        //합집합 갯수 구하기
        for(int i = 0; i < 2; i++)
        {
            for(String key : m[i].keySet())
            {
                int max = Math.max(m[i].get(key), m[2-i-1].getOrDefault(key,0));
                hapCtn += max;
                m[2-i-1].remove(key);
            }
        }
        
        if(gyoCtn == 0 && hapCtn == 0) //합,교집합 모두 0일 경우에만
            return 65536;
        else
            return (int)(((double)gyoCtn / hapCtn) * 65536); 
    }
}