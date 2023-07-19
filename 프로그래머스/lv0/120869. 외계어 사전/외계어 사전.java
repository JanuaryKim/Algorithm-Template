class Solution {
    public int solution(String[] spell, String[] dic) {
        
        for(int i = 0; i < dic.length; i++)
        {
            boolean check = true;
            for(int j = 0; j < spell.length; j++)
            {
                if(!dic[i].contains(spell[j]))
                {
                    check = false;
                    break;
                }
            }
            if(check) 
                return 1;
        }
        return 2;
    }
}

