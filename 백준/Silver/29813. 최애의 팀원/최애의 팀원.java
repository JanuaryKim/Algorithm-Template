import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static class Student{
        String name;
        int num;

        public Student(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Student> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            String[] stInfo = br.readLine().split(" ");
            queue.add(new Student(stInfo[0], Integer.parseInt(stInfo[1])));
        }

        while(queue.size() > 1) {
            Student student = queue.poll();
            int mateSeq = student.num - 1;
            for(int i = 0; i < mateSeq; i++){
                queue.add(queue.poll());
            }
            Student mate = queue.poll();
        }

        System.out.println(queue.peek().name);
    }
}
