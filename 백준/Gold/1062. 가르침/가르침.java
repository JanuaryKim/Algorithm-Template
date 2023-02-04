import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static String[] words;
    static boolean[] alphabet = new boolean[26];
    static int n,k;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken()); //단어 갯수
        k = Integer.parseInt(st.nextToken()); //가르칠 수 있는 문자 갯수
        
        alphabet['a'-'a'] = true;
        alphabet['c'-'a'] = true;
        alphabet['i'-'a'] = true;
        alphabet['n'-'a'] = true;
        alphabet['t'-'a'] = true;

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = bf.readLine();
        }

        if (k < 5) {
            System.out.println(0);
            return;
        }
        dfs(5, 0);
        System.out.println(max);
    }

    static void dfs(int chCtn, int index) {

        if (chCtn == k) {
            int learnCtn = checkWord();
            if(learnCtn > max)
                max = learnCtn;
            return;
        }

        for (int i = index; i < 26; i++) {
            if(alphabet[i])
                continue;
            alphabet[i] = true;
            dfs(chCtn+1, i+1);
            alphabet[i] = false;
        }
    }

    static int checkWord() {
        int ctn = 0;
        for (int i = 0; i < words.length; i++) {
            boolean check = true;
            String word = words[i];
            for (int j = 4; j < word.length() - 4; j++) {
                char c = word.charAt(j);
                if (!alphabet[c - 'a']) {
                    check = false;
                    break;
                }
            }
            if(!check)
                continue;
            ctn++;
        }
        return ctn;
    }
}