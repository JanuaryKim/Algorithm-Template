class Solution {
    //485 반례-> 11
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0){
            int one = storey % 10; //일의 자리
            int ten = (storey / 10) % 10; //십의 자리, 일의자리가 5일 경우에를 위해 필요
            if(one < 5) {
                storey -= one;
                answer += one;
            }
            else if(one > 5){
                storey += 10 - one;
                answer += 10 - one;
            }
            else{
                if(ten >= 5) //십의 자리가 5 이상일 경우 더해줘야 함.
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
