import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int ctn = Integer.parseInt(bf.readLine());

        List<Picture> pictures = new LinkedList<>();
        int orderIdx = 0;

        int[] numbers = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        for(int i = 0; i < numbers.length; i++){

            boolean check = false;
            for(int j = 0; j < pictures.size(); j++){
                if(pictures.get(j).num == numbers[i])
                {
                    check = true;
                    pictures.get(j).recommend++;
                }
            }

            if(check) continue;

            if(pictures.size() == n){
                Collections.sort(pictures, (p1, p2) -> {
                   if(p1.recommend - p2.recommend == 0){
                       return p2.order - p1.order;
                   }
                   else{
                       return p2.recommend - p1.recommend;
                   }
                });
                pictures.remove(n-1);
            }
            pictures.add(new Picture(numbers[i],1, orderIdx++));
        }

        Collections.sort(pictures, Comparator.comparingInt(p -> p.num));
        for (int i = 0; i < pictures.size(); i++) {
            System.out.print(pictures.get(i).num);
            if(i != n-1)
                System.out.print(" ");
        }
    }
    private static class Picture {

        int num = 0;
        int recommend = 0;
        int order = 0;

        public Picture(int num, int recommend, int order) {
            this.num = num;
            this.recommend = recommend;
            this.order = order;
        }
    }
}
