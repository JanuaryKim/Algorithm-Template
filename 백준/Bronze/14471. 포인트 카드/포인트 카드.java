    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;

    public class Main {
        public static void main(String[] args) throws IOException {
            int result = 0;
            int satisfyCnt = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] strNM = br.readLine().split(" ");
            int n = Integer.parseInt(strNM[0]);
            int m = Integer.parseInt(strNM[1]);
            int[] goodStampCnt = new int[m];
            for(int i = 0; i < m; i++) {
                String[] card = br.readLine().split(" ");
                goodStampCnt[i] = Integer.parseInt(card[0]);
            }
            Arrays.sort(goodStampCnt);
            
            for(int i = m - 1; i >= 0; i--){
                if(goodStampCnt[i] >= n) {
                    satisfyCnt++;
                }
                else{
                    if(satisfyCnt >= m-1) break;
                    else{
                        result += n - goodStampCnt[i];
                        satisfyCnt++;
                    }
                }
            }

            System.out.println(result);
        }
    }
