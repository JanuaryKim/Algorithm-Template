class Solution {
    //485 반례-> 11
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0){
            int one = storey % 10;
            int ten = (storey / 10) % 10;
            if(one < 5) {
                storey -= one;
                answer += one;
            }
            else if(one > 5){
                storey += 10 - one;
                answer += 10 - one;
            }
            else{
                if(ten >= 5)
                {
                    storey += 10 - one;
                    answer += 10 - one;
                }
                else{
                    storey -= one;
                    answer += one;
                }
            }
            storey = storey / 10;
        }
        
        return answer;
    }
}