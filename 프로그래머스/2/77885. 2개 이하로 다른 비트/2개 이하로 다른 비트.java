class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        for(int i=0; i<len; i++){
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i] + 1;
            }

            else{
                long tmp = numbers[i];
                long cal=1;
                int cnt=0;
            
                while(tmp>0){
                    if(tmp % 2 == 1)
                        cnt++;
                    else
                        break;
                    tmp /= 2;
                }
                for(int j=0; j<cnt-1; j++){
                    cal*=2;
                }
                answer[i] = numbers[i] + cal;
            }
        }
        return answer;
    }
}