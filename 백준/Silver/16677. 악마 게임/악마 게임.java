import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String oriString = bf.readLine();
        int n = Integer.parseInt(bf.readLine());
        List<GabbunStr> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] input = bf.readLine().split(" ");
            GabbunStr gbStr = new GabbunStr(input[0], Float.parseFloat(input[1]), i);
            list.add(gbStr);
        }

        List<GabbunStr> filteredList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int tempIdx = 0;
            GabbunStr gbStr = list.get(i);
            for(int j = 0; j < gbStr.str.length(); j++){

                if(tempIdx < oriString.length() && oriString.charAt(tempIdx) == gbStr.str.charAt((j))){
                    tempIdx++;
                }
                else{
                    gbStr.addedCnt++;
                }
            }

            if(tempIdx == oriString.length()){
                filteredList.add(gbStr);
            }
        }

        for(GabbunStr gbStr : filteredList){


            gbStr.calcScore = gbStr.score / (gbStr.addedCnt == 0 ? 1f : gbStr.addedCnt); //추가된 문자가 1개도 없는 문자시 0으로 나눠서 예외발생 가능성
        }

        Collections.sort(filteredList, (gb1, gb2) -> {
            if(gb1.calcScore > gb2.calcScore) return -1;
            else if(gb1.calcScore < gb2.calcScore) return 1;
            else{
                if(gb1.order < gb2.order) return -1;
                else if(gb1.order > gb2.order) return 1;
                else {
                    return 0;
                }
            }
        });

        if(filteredList.size() == 0)
            System.out.println("No Jam");
        else
            System.out.println(filteredList.get(0).str);
    }

    private static class GabbunStr{

        String str;
        float score; //갑분싸 값이 소수로 들어 올 경우 대비
        int order;
        int addedCnt;
        float calcScore; //가성비는 나눗셈으로 발생되기 때문에 소수점이 발생 가능함

        public GabbunStr(String str, float score, int order) {
            this.str = str;
            this.score = score;
            this.order = order;
        }

        @Override
        public String toString() {
            return "GabbunStr{" +
                    "str='" + str + '\'' +
                    ", score=" + score +
                    ", order=" + order +
                    ", addedCnt=" + addedCnt +
                    ", calcScore=" + calcScore +
                    '}';
        }
    }

    // 주요한 예외사항
    // 1. 갑분싸값이 소수인 경우
    // 2. 가성비는 나눗셈으로 발생되기 때문에 소수점으로 발생될 수 있다. 
    //      이 경우, 만약 가성비값이 4.9인것과 4.0 인것은 float을 사용하여 명확히 비교해 주어야 한다
    // 3. n의 값이 1인 경우
    
    
    // 수도코드
    // 추가열 문자열들을 사용자 정의 클래스로 담음
    //  해당 클래스의 변수
    //      문자열
    //      입력된 순서
    //      추가된 문자 갯수
    
    //추가 문자열 문자열 갯수만큼 반복
    //  인덱스 = 0
    //  추가된 문자 갯수 = 0;
    //      i번째 문자열 길이 만큼 반복
    //
    //          만약 인덱스가 문자열의 길이 보다 작고 && 이번 문자가 원본문자열.charAt(0) 의 값과 같다면
    //              인덱스 증가
    //          같지 않다면
    //              추가된 문자 갯수 증가
    //      ~
    //      만약 인덱스가 이번 문자열의 길이와 같다면 (원본 문자열의 모든 문자들이 순서대로 존재하는 상태)
    //          갑분싸 대상이 되는 문자열로 판명
    //~

    //갑분싸 대상이 되는 문자열 리스트를 가성비가 높은 순으로 정렬하되 같다면 입력된 순서가 먼저인 것으로 정렬한다
}
