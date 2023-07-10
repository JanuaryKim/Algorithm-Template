import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        List<Integer> lostList = new ArrayList();
        
        for(int i = 0; i < lost.length; i++)
        {
            lostList.add(lost[i]);
        }
        
        List<Integer> reserveList = new ArrayList();
        
        for(int i = 0; i < reserve.length; i++)
        {
            reserveList.add(reserve[i]);
        }
        
        Collections.sort(lostList);
        Collections.sort(reserveList);
        
        for(int i = lostList.size() - 1; i >= 0; i--)
        {
            int lostNumber = lostList.get(i);
            
            for(int j = 0; j < reserveList.size(); j++)
            {
                if(reserveList.get(j) == lostNumber)
                {
                    reserveList.remove(j);
                    lostList.remove(i);
                    break;
                }
            }
        }
        
        int reserveCtn = 0;
        for(int i = 0; i < lostList.size(); i++)
        {
            int lostNumber = lostList.get(i);
            
            for(int j = 0; j < reserveList.size(); j++)
            {
                if(reserveList.get(j) == lostNumber - 1)
                {
                    reserveCtn++;
                    reserveList.remove(j);
                    break;
                }
                else if(reserveList.get(j) == lostNumber + 1)
                {
                    reserveCtn++;
                    reserveList.remove(j);
                    break;
                }
            }
        }
        
        return n - lostList.size() + reserveCtn;
    }
}