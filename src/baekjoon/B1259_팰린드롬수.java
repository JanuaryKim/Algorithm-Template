package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder sb = new StringBuilder();

        while (true) {

            input = bf.readLine();

            if (input.equals("0"))
                break;

            int left = 0;
            int right = input.length()-1;
            boolean isEqual = true;

            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) {
                    isEqual = false;
                }
                left++;
                right--;
            }

            if(isEqual)
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.println(sb);
    }
}
