import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        int[] alphabet = new int[26];

        for (int i = 0; i < t; i++) {
            String str = bf.readLine();

            int pow = str.length()-1;

            for (int j = 0; j < str.length(); j++) {

                char ch = str.charAt(j);
                alphabet[ch - 'A'] += (int)Math.pow(10, pow--);

            }
        }

        Arrays.sort(alphabet);

        int value = 9;
        int sum = 0;
        for (int i = alphabet.length-1; i >= 0; i--) {
            if(alphabet[i] == 0)
                break;

            sum += alphabet[i] * value--;
        }
        System.out.println(sum);
    }
}