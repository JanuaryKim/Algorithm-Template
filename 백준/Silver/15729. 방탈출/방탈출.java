import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//최초 모두 꺼진 라이트 배열을, 요소 하나씩 검사하여 목표 배열의 라이트 상태와 다르다면 해당 라이트 누름.
public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String input = bf.readLine();
        boolean[] desLight = new boolean[n];
        int idx = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '0'){
                idx++;
            }
            else if(input.charAt(i) == '1'){
                desLight[idx++] = true;
            }
        }
        boolean[] light = new boolean[n];
        for(int i = 0; i < n; i++){
            if(light[i] != desLight[i]){
                int limit = Math.min(i + 3, n);
                for(int j = i; j < limit; j++){
                    light[j] = !light[j];
                }
                result++;
            }
        }
        System.out.println(result);
    }
}
