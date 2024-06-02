import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] splCheese = bf.readLine().split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String name : splCheese){
            if(name.endsWith("Cheese")){
                map.put(name,map.getOrDefault(name, 0) + 1);
            }
        }
        if(map.size() >= 4) System.out.println("yummy");
        else System.out.println("sad");
    }
}
