package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/** 성공 **/
public class B10828_스택 {
    public static void main(String[] args) throws IOException {

        CustomStack stack = new CustomStack();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = bf.readLine();

            String[] s = input.split(" ");
            String command = s[0];
            if (command.equals("push")) {

                stack.push(Integer.parseInt(s[1]));

            } else if (command.equals("pop")) {

                sb.append(stack.pop() + "\n");

            } else if (command.equals("size")) {

                sb.append(stack.size() + "\n");

            } else if (command.equals("empty")) {

                sb.append(stack.empty() + "\n");

            } else if (command.equals("top")) {

                sb.append(stack.top() + "\n");

            }
        }

        System.out.println(sb);
    }

    static class CustomStack{

        List<Integer> data = new LinkedList<>();
        int idx = -1;

        public void push(int value) {
            data.add(value);
            idx++;
        }
        public int pop() {

            if(data.isEmpty())
                return -1;

            Integer value = data.get(idx);
            data.remove(idx);
            idx--;
            return value;
        }
        public int size() {
            return data.size();
        }
        public int empty() {
            return data.isEmpty()? 1 : 0;
        }
        public int top() {

            return data.isEmpty()? -1 : data.get(idx);
        }
    }
}


