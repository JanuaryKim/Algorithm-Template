import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//14670
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<String, String> medicine = new HashMap<>();
        for(int i = 0; i < n; i++){
            String[] strMedi = bf.readLine().split(" ");
            medicine.put(strMedi[0], strMedi[1]);
        }

        int r = Integer.parseInt(bf.readLine());

        String[][] react = new String[r][];
        for(int i = 0; i < r; i++){
            String[] subReact = bf.readLine().split(" ");
            react[i] = subReact;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < r; i++){

            StringBuilder subSB = new StringBuilder();

            for(int j = 1; j < react[i].length; j++){
                String singleSubReact = medicine.get(react[i][j]);
                if(singleSubReact != null) subSB.append(singleSubReact);
                else {
                    subSB.setLength(0); //StringBuilder 비우기, 새로운 객체 생성보다 성능 좋음
                    subSB.append("YOU DIED");
                    break;
                }

                if(j != react[i].length-1) subSB.append(" ");
            }
            if(i != r-1)
                subSB.append("\n");
            sb.append(subSB);
        }

        printResult(sb);
    }

    private static void printResult(StringBuilder rsb){
        System.out.println(rsb);
    }
}
