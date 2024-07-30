import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//5766
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String[] splNm = bf.readLine().split(" ");
            if(splNm[0].equals("0") && splNm[1].equals("0")) break;

            int n = Integer.parseInt(splNm[0]);
            int m = Integer.parseInt(splNm[1]);

            HashMap<String, Person> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                String line = bf.readLine();
                String[] rank = line.split(" ");
                for(int j = 0; j < rank.length; j++){
                    String strNum = rank[j];
                    Person p = map.get(strNum);
                    if(p == null) map.put(strNum, new Person(strNum, 1));
                    else{
                        p.cnt = p.cnt + 1;
                    }
                }
            }
            Collection<Person> values = map.values();

            List<Person> persons = new ArrayList<>(values);
            Collections.sort(persons, (p1, p2) ->{
                if(p1.cnt > p2.cnt) return -1;
                else if(p1.cnt == p2.cnt) {
                    return Integer.parseInt(p1.num) - Integer.parseInt(p2.num);
                }
                else return 1;
            });

            int secondScore = persons.get(1).cnt;

            for(int i = 1; i < persons.size(); i++){
                Person curPerson = persons.get(i);
                if(secondScore == curPerson.cnt) {
                    sb.append(curPerson.num );
                    sb.append(" ");
                }
                else break;
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }

    static class Person{
        String num = "";
        int cnt = 0;

        public Person(String num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "num='" + num + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
