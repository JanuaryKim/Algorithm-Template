import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        //글자 갯수별로 쪼개기.

        int pCnt = 13, kCnt = 13, hCnt = 13, tCnt = 13;
        Map<String, boolean[]> map = new HashMap<>();
        
        map.put("P", new boolean[13]);
        map.put("K", new boolean[13]);
        map.put("H", new boolean[13]);
        map.put("T", new boolean[13]);
        

        for(int i = 0; i <= input.length() - 3; i += 3){
            String card = input.substring(i, i + 3);
            String pattern = card.substring(0, 1);
            int num = Integer.parseInt(card.substring(1, 3));

            boolean[] checking = map.get(pattern);

            if(checking[num - 1]) { //이미 체크 됬다면
                System.out.println("GRESKA");
                return;
            }
            else{
                checking[num - 1] = true;
            }

            if(pattern.equals("P"))
                pCnt--;
            else if(pattern.equals("K"))
                kCnt--;
            else if(pattern.equals("H"))
                hCnt--;
            else if(pattern.equals("T"))
                tCnt--;

        }

        System.out.println(pCnt + " " + kCnt + " " + hCnt + " " + tCnt);
    }
}
