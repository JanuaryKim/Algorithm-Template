class Solution {
    public String solution(int[] food) {
        String preStr = "";
        String sufStr = "";
        for(int i=1; i<food.length; i++){
            int repeatCnt = (food[i] - (food[i] % 2 == 0 ? 0 : 1) / 2) / 2;
            preStr += String.valueOf(i).repeat(repeatCnt);
            sufStr = String.valueOf(i).repeat(repeatCnt) + sufStr;
        }
        return preStr + "0" + sufStr;
    }
}