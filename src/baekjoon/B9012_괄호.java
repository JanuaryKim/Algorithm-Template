package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/** 성공 **/
public class B9012_괄호 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack;
        for (int i = 0; i < n; i++) {

            String input = bf.readLine();
            stack = new Stack<>();
            boolean result = true;
            for (int j = 0; j < input.length(); j++) {

                if (input.charAt(j) == '(') {
                    stack.push(1);
                } else {
                    if (stack.empty()) {
                        result = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!result || (result && !stack.empty())) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
    }
}
