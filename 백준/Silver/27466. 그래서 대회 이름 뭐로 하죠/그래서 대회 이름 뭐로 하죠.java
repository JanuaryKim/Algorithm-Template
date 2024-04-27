import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //AA두개 존재해야 하고, 자음 하나 존재해야함.
        //이렇게 하고도 나머지 문자 갯수가 m-3 개는 존재해야 함.

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] spl = bf.readLine().split(" ");
        int n = Integer.parseInt(spl[0]);
        int m = Integer.parseInt(spl[1]);
        String s = bf.readLine();

        boolean possible = false;
        List<Integer> aIdxs = new ArrayList<>();
        int sonIdx = -1;
        int aCnt = 0;
        int sonCnt = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == 'A') {
                aCnt++;
                if(aIdxs.size() < 2)
                    aIdxs.add(i);
            }
            if(c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                sonCnt++;
                if(sonIdx == -1)
                    sonIdx = i;
            }
            if(aCnt >= 2 && sonCnt > 0){
                if((n-3) > (m-3)){
                    possible = true;
                    break;
                }
            }
        }


        if(possible) {
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                if(!aIdxs.contains(i) && i != sonIdx){
                    sb.append(s.charAt(i));
                }
                if(sb.length() == (m-3)){
                    break;
                }
            }
            sb.append("AA" + s.charAt(sonIdx));
            System.out.println(sb);
        }else {
            System.out.println("NO");
        }

    }
}
