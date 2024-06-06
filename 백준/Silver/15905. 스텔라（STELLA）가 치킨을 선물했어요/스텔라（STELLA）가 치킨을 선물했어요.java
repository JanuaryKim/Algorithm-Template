import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            String[] splStr = bf.readLine().split(" ");
            students[i] = new Student(Integer.parseInt(splStr[0]), Integer.parseInt(splStr[1]));
        }

        Arrays.sort(students, (s1, s2) -> {
           if(s2.solveCnt > s1.solveCnt) return 1;
           else if(s2.solveCnt < s1.solveCnt) return -1;
           else{
               return s1.pScore - s2.pScore;
           }
        });

        for(int i = 5; i < n; i++){
            if(students[4].solveCnt == students[i].solveCnt && students[4].pScore < students[i].pScore) result++;
        }
        System.out.println(result);
    }

    static class Student{
        int solveCnt = 0;
        int pScore = 0;

        public Student(int solveCnt, int pScore) {
            this.solveCnt = solveCnt;
            this.pScore = pScore;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "solveCnt=" + solveCnt +
                    ", pScore=" + pScore +
                    '}';
        }
    }
}
