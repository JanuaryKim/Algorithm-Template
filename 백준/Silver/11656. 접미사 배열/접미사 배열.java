import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer S = new StringBuffer(bf.readLine());

        String[] arr = new String[S.length()];

        int idx = 0;
        while(S.length() > 0){
            arr[idx++] = S.toString();
            S.deleteCharAt(0);
        }

        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
