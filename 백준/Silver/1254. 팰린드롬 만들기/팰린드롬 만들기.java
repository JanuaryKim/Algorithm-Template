import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1254
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String oriWord = bf.readLine();

        StringBuilder newWord = new StringBuilder();
        for(int i = 0; i < oriWord.length(); i++){
            newWord.append(oriWord.charAt(i));
            if(i != oriWord.length()-1)
                newWord.append(" ");
        }

        int middle = newWord.length() / 2;
        int left = middle - 1;
        int right = middle + 1;
        while(true) {

            if (left < 0 && right > newWord.length() - 1)
                break;
            else if (right > newWord.length() - 1) {
                newWord.append(newWord.charAt(left));
            }

            if (newWord.charAt(left) != newWord.charAt(right)) {
                middle++;
                left = middle - 1;
                right = middle + 1;
            } else {
                left--;
                right++;
            }
        }
        System.out.println(new String(newWord).replaceAll(" ", "").length());
    }
}
//투포인터를 사용 함
    //입력받은 문자열의 문자 사이마다 빈칸이 들어간 새로운 문자열 생성

    //반복 시작
    //만약 왼쪽, 오른쪽 포인터 모두 범위를 벗어나게 됬다면 팰린드롬이 된것이므로 반복 break;
    //만약 오른쪽 포인터가 전체 길이보다 길어졌다면 (중앙 기준으로 왼쪽과 동일하게 오른쪽도 맞춰줘야 함)
    //  왼쪽 포인터의문자를 그대로 오른쪽에 붙여줌
    //중앙 인덱스를 중심으로 left, right 위치의 문자가 같은지 탐색
    //만약 같지 않을 경우
    //  기준인 중앙 인덱스를 오른쪽으로 옮김 (중심을 옮겨야 문자열의 오른쪽 끝에 새로운 문자를 추가하여 펠린드롬을 만들 수 있기때문에)
    //  새로운 중앙 기준으로 left, right 인덱스 새로 설정
    //만약 같다면
    //  투포인터 각각 앞으로 이동
    //~반복 종료
    
    //로직을 위해 각 문자 사이마다 빈칸 넣었던것 제거하고 전체 문자열 길이가 정답