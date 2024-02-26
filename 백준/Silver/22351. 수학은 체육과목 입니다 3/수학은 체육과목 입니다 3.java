import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        for(int i = 1; i < 1000; i++){
            String start = String.valueOf(i);
            String end = "";
            if(line.startsWith(start)){ //첫 숫자를 찾아냄
                String tempLine = line;
                boolean check = true;
                for(int j = i; j < 1000; j++){ //첫 숫자부터 시작하여 문자열내에 존재할 수 있는 999까지의 숫자를 모두 탐색 해봄. (끝 숫자가 999 미만이면 그전에 반복문은 끝날것이다)
                    String curNumStr = String.valueOf(j);
                    if(tempLine.startsWith(curNumStr)){ //이번 숫자가 현재 문자열에 시작 숫자라면
                        tempLine = tempLine.substring(curNumStr.length()); //시작 숫자를 떼어낸 만큼의 문자열을 현재 문자열에 넣음
                        end = curNumStr; //떼어낸 뒤 현재 문자열이 ""이 되어, 문자열의 모든 탐색이 끝났을때, 마지막으로 떼어낸 숫자문자열을 저장해 둠.
                    }
                    else if(tempLine.equals("")){ //이미 모든 문자열의 탐색을 끝낸것이므로 정답을 찾은 상황
                        break;
                    }
                    else{ //이번 숫자가 현재 문자열의 시작 숫자가 아니라면 정답에 도달할 수 없으므로 탐색 종료
                        check =false;
                        break;
                    }
                }
                if(check){
                    System.out.println(start + " " + end);
                    return;
                }
            }
        }
    }
}