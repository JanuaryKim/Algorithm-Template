import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] splLine = line.split(" ");
        int n = Integer.parseInt(splLine[0]);
        int m = Integer.parseInt(splLine[1]);

        Map<String, Integer> wordsCountingMap = new HashMap<>();
        List<String> wordsList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String word = bf.readLine();
            if(word.length() < m) continue;
            wordsList.add(word);
            wordsCountingMap.put(word, wordsCountingMap.getOrDefault(word, 0) + 1);
        }

        Collections.sort(wordsList, (w1,w2) -> {
            if(wordsCountingMap.get(w1) > wordsCountingMap.get(w2)){
                return -1;
            } else if (wordsCountingMap.get(w1) < wordsCountingMap.get(w2)) {
                return 1;
            }
            else{
                return w2.length() > w1.length() ? 1 : (w2.length() < w1.length() ? -1 : (w1.compareTo(w2)));
            }
        });

        String[] result = wordsList.stream().distinct().toArray(String[]::new);
        StringBuilder sb= new StringBuilder();
        for(int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if(i != result.length - 1) sb.append("\n");
        }
        System.out.println(sb);
    }
}
