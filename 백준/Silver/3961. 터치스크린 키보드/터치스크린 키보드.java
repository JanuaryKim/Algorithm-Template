import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static class RecommendVocabulary{
        String vocabulary;
        int diffSum;
    }
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        Map<Character, int[]> map = new HashMap<>();
        map.put('q',new int[]{0,0});
        map.put('w',new int[]{0,1});
        map.put('e',new int[]{0,2});
        map.put('r',new int[]{0,3});
        map.put('t',new int[]{0,4});
        map.put('y',new int[]{0,5});
        map.put('u',new int[]{0,6});
        map.put('i',new int[]{0,7});
        map.put('o',new int[]{0,8});
        map.put('p',new int[]{0,9});

        map.put('a',new int[]{1,0});
        map.put('s',new int[]{1,1});
        map.put('d',new int[]{1,2});
        map.put('f',new int[]{1,3});
        map.put('g',new int[]{1,4});
        map.put('h',new int[]{1,5});
        map.put('j',new int[]{1,6});
        map.put('k',new int[]{1,7});
        map.put('l',new int[]{1,8});

        map.put('z',new int[]{2,0});
        map.put('x',new int[]{2,1});
        map.put('c',new int[]{2,2});
        map.put('v',new int[]{2,3});
        map.put('b',new int[]{2,4});
        map.put('n',new int[]{2,5});
        map.put('m',new int[]{2,6});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            String[] input = br.readLine().split(" ");
            String inputVoca = input[0];
            int inputRecommendCnt = Integer.parseInt(input[1]);

            RecommendVocabulary[] recommendVocas = new RecommendVocabulary[inputRecommendCnt];

            for(int j = 0; j < inputRecommendCnt; j++){
                recommendVocas[j] = new RecommendVocabulary();
                recommendVocas[j].vocabulary = br.readLine();
            }


            int vocaLeng = inputVoca.length();

            for(int j = 0; j < inputRecommendCnt; j++){
                for(int z = 0; z < vocaLeng; z++){
                    int[] inputPos = map.get(inputVoca.charAt(z));
                    int[] recomPos = map.get(recommendVocas[j].vocabulary.charAt(z));
                    recommendVocas[j].diffSum += Math.abs(inputPos[0] - recomPos[0]);
                    recommendVocas[j].diffSum += Math.abs(inputPos[1] - recomPos[1]);
                }
            }

            Arrays.sort(recommendVocas, (a,b) -> {
                if(a.diffSum - b.diffSum < 0) return -1;
                else if(a.diffSum - b.diffSum > 0) return 1;
                else return a.vocabulary.compareTo(b.vocabulary);
            });

            //답 세팅
            for(int j = 0; j < inputRecommendCnt; j++){
                sb.append(recommendVocas[j].vocabulary + " " + recommendVocas[j].diffSum);
                sb.append("\n");
            }


        }

        System.out.println(sb);
    }
}


