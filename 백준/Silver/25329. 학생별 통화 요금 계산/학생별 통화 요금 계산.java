import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//25329
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<String, Student> studentMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            String[] phoneHis = bf.readLine().split(" ");

            String[] strHM = phoneHis[0].split(":");
            int h = Integer.parseInt(strHM[0]);
            int m = Integer.parseInt(strHM[1]);
            String name = phoneHis[1];
            Student s = studentMap.getOrDefault(name, new Student(name, 0));
            s.minute += (h * 60) + m;
            studentMap.put(name, s);
        }

        List<Student> list = new ArrayList<>(studentMap.values());

        for(int i = 0; i < list.size(); i++){
            Student s = list.get(i);
            if(s.minute <= 100) s.cost = 10;
            else{
                s.cost = 10;
                s.minute -= 100;
                double addValue = Math.ceil((double)s.minute / 50);
                s.cost += (addValue * 3);
                s.minute = 0;
            }
        }

        Collections.sort(list, (s1, s2) -> {
            if(s1.cost > s2.cost) return -1;
            else if(s1.cost < s2.cost) return 1;
            else{
                return s1.name.compareTo(s2.name);
            }
        });
        for(Student s : list){
            System.out.println(s.name + " " + s.cost);
        }
    }

    static class Student{
        String name;
        int minute;
        int cost;
        public Student(String name, int minute) {
            this.name = name;
            this.minute = minute;
        }
    }
}
