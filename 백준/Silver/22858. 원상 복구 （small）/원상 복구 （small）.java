import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStrNK = bf.readLine().split(" ");
        int N = Integer.parseInt(inputStrNK[0]);
        int K = Integer.parseInt(inputStrNK[1]);

        String[] inputStrS = bf.readLine().split(" ");
        int[] inputD = Arrays.stream(bf.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        String[] preCards = inputStrS;
        String[] result = Arrays.copyOf(inputStrS, inputStrS.length);

        for(int i = 0; i < K; i++){
            for(int j = 0; j < N; j++){
                result[inputD[j]-1] = preCards[j];
            }
            preCards = Arrays.copyOf(result, result.length);
        }


        for(int i = 0; i < N; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
