class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int result = 0;
        for(String s : skill_trees){
            String[] spl = s.split("");
            int pre = -1;
            boolean check = true;
            for(String ss : spl){
                
                int cur = skill.indexOf(ss);
                if(cur == -1) continue;
                if(pre - cur != -1) {
                    check = false;
                    break;
                }
                pre = cur;
            }
            
            if(check)
                result++;
        }
        return result;
    }
}