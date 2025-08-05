import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strNK = br.readLine().split(" ");
        int n = Integer.parseInt(strNK[0]);
        int k = Integer.parseInt(strNK[1]);
        char[] curPan = br.readLine().toCharArray();
        char[] nextPan = new char[n];

        String[] patternG = {"BRR", "GGR", "BBG"};
        String[] patternR = {"GRR", "BGG", "BBR"};

        int r = 0;
        int g = 0;
        int b = 0;

        for (int i = 0; i < k; i++) {
            int preIdx = 0;
            int nextIdx = 0;
            char[] temp = new char[3];

            for(int j = 0; j < n; j++){

                preIdx = j - 1 < 0 ? n - 1 : j - 1;
                nextIdx = j + 1 >= n ? 0 : j + 1;
                temp[0] = curPan[preIdx];
                temp[1] = curPan[j];
                temp[2] = curPan[nextIdx];

                Arrays.sort(temp);
                String sortedStr = String.valueOf(temp);
                int check = 0; // 0 : 발견 못함, 1 : 초록, 2 : 빨강
                for(int z = 0; z < 3; z++){
                    if(patternG[z].equals(sortedStr)) {
                        check = 1;
                        break;
                    }
                }

                for(int z = 0; z < 3; z++){
                    if(patternR[z].equals(sortedStr)) {
                        check = 2;
                        break;
                    }
                }

                if(check == 0) nextPan[j] = 'B';
                else if(check == 1) nextPan[j] = 'G';
                else nextPan[j] = 'R';
            }

            curPan = nextPan.clone();
        }

        for(int i = 0; i < n; i++){
            if(curPan[i] == 'R') r++;
            else if(curPan[i] == 'G') g++;
            else b++;
        }

        System.out.println(r + " " + g + " " + b);
    }
}
