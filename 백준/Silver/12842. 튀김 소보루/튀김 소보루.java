import java.io.*;
import java.util.*;

public class Main {

    static class Person implements Comparable<Person>{
        int num;
        int time;

        public Person(int person, int time) {
            this.num = person;
            this.time = time;
        }

        @Override
        public int compareTo(Person o) {
            if(this.time == o.time){ // 동시에 다 먹으면
                return this.num - o.num; // 작은 번호 순
            }
            return this.time - o.time; // 빨리 먹는 시간 순
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int m = Integer.parseInt(br.readLine());
        int[] people = new int[m+1];
        int answer = -1;

        for(int i=1; i<=m; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Person> pq = new PriorityQueue<>();

        int cnt = n; // 처음 소보루의 개수
        for(int i=1; i<=m; i++) {
            pq.add(new Person(i, people[i]));
            cnt--;
            if(cnt == s) {
                answer = i;
                break;
            }
        }

        if(answer == -1) {
            int num = -1;
            while(cnt > s) {
                Person cur = pq.poll();
                num = cur.num;
                int finishedTime = cur.time;
                pq.add(new Person(num, finishedTime + people[num]));
                cnt--;
                // 동시에 빵을 다 먹은 사람들을 작은 번호 순대로 빵 집기
                while(cnt > s && finishedTime == pq.peek().time) {
                    cur = pq.poll();
                    num = cur.num;
                    pq.add(new Person(num, finishedTime + people[num]));
                    cnt--;
                }
            }
            answer = num;
        }
        System.out.println(answer);
    }
}