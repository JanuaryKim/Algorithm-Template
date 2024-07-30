import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//5635
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Person[] ps = new Person[n];
        for(int i = 0; i < n; i++){
            String line = bf.readLine();
            String[] spl = line.split(" ");
            ps[i] = new Person(spl[0], Integer.parseInt(spl[1]), Integer.parseInt(spl[2]), Integer.parseInt(spl[3]));
        }

        Arrays.sort(ps, (p1, p2) -> {
            if(p1.y < p2.y) return -1;
            else if(p1.y > p2.y) return 1;
            else {
                if(p1.m < p2.m) return -1;
                else if(p1.m > p2.m) return 1;
                else{
                    return p1.d - p2.d;
                }
            }
        });

        System.out.println(ps[n-1].name);
        System.out.println(ps[0].name);
    }

    static class Person{
        String name;
        int d;
        int m;
        int y;
        public Person(String name, int d, int m, int y) {
            this.name = name;
            this.d = d;
            this.m = m;
            this.y = y;
        }
    }
}
