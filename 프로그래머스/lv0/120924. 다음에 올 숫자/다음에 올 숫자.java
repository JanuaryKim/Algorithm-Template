class Solution {
    public int solution(int[] common) {
        
        int result = common[1] - common[0];
        boolean check = true;
        int diff = 0;
        for(int i = 2; i < common.length; i++)
        {
            diff = common[i] - common[i-1];
            if(result != diff) {
                check = false;
                
                break;
            }
        }
        if(check) {
            return common[common.length-1] + diff;
        }
        else {
            diff = common[common.length-1] / common[common.length-2];
            return common[common.length-1] * diff;
        }
    }
}