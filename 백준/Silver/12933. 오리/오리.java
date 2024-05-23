import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//12933
//quack
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sound = bf.readLine();

        List<Stack<Character>> list = new ArrayList<>();
        for(int i = 0; i < sound.length(); i++){
            char c = sound.charAt(i);

            boolean find = false;
            switch(c){
                case 'q':
                    for(Stack s : list){
                        if (s.peek().equals('k')) {
                            s.add('q');
                            find = true;
                            break;
                        }
                    }
                    Stack newStack = new Stack<>();
                    newStack.add('q');
                    if(!find) list.add(newStack);
                    break;
                case 'u':
                    for(Stack s : list){
                        if (s.peek().equals('q')) {
                            s.add('u');
                            find = true;
                            break;
                        }
                    }
                    if(!find) {
                        System.out.println(-1);
                        return;
                    }
                    break;
                case 'a':
                    for(Stack s : list){
                        if (s.peek().equals('u')) {
                            s.add('a');
                            find = true;
                            break;
                        }
                    }
                    if(!find) {
                        System.out.println(-1);
                        return;
                    }
                    break;
                case 'c':
                    for(Stack s : list){
                        if (s.peek().equals('a')) {
                            s.add('c');
                            find = true;
                            break;
                        }
                    }
                    if(!find) {
                        System.out.println(-1);
                        return;
                    }
                    break;
                case 'k':
                    for(Stack s : list){
                        if (s.peek().equals('c')) {
                            s.add('k');
                            find = true;
                            break;
                        }
                    }
                    if(!find) {
                        System.out.println(-1);
                        return;
                    }
                    break;

            }
        }
        for(Stack s : list){
            if (!s.peek().equals('k')) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(list.size());
    }
}
