import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] splStr = bf.readLine().split(" ");
        String line = bf.readLine();

        Map<Character, int[]> leftFingerKeys = new HashMap();
        Map<Character, int[]> rightFingerKeys = new HashMap();
        keysInit(true, leftFingerKeys);
        keysInit(false, rightFingerKeys);
        int[] curLeftPos = leftFingerKeys.get(splStr[0].charAt(0));
        int[] curRightPos = rightFingerKeys.get(splStr[1].charAt(0));

        for(int i = 0; i < line.length(); i++){

            char curC = line.charAt(i);

            if(leftFingerKeys.containsKey(curC)){
                int[] cPos = leftFingerKeys.get(curC);
                result += Math.abs(curLeftPos[0] - cPos[0]);
                result += Math.abs(curLeftPos[1] - cPos[1]);
                result++;
                curLeftPos = cPos;
            }
            else{
                int[] cPos = rightFingerKeys.get(curC);
                result += Math.abs(curRightPos[0] - cPos[0]);
                result += Math.abs(curRightPos[1] - cPos[1]);
                result++;
                curRightPos = cPos;
            }
        }
        System.out.println(result);
    }

    public static void keysInit(boolean left, Map<Character, int[]> keysMap){

        if(left){
            keysMap.put('q', new int[]{0,0});
            keysMap.put('w', new int[]{0,1});
            keysMap.put('e', new int[]{0,2});
            keysMap.put('r', new int[]{0,3});
            keysMap.put('t', new int[]{0,4});

            keysMap.put('a', new int[]{1,0});
            keysMap.put('s', new int[]{1,1});
            keysMap.put('d', new int[]{1,2});
            keysMap.put('f', new int[]{1,3});
            keysMap.put('g', new int[]{1,4});

            keysMap.put('z', new int[]{2,0});
            keysMap.put('x', new int[]{2,1});
            keysMap.put('c', new int[]{2,2});
            keysMap.put('v', new int[]{2,3});
        }
        else{
            keysMap.put('y', new int[]{0,5});
            keysMap.put('u', new int[]{0,6});
            keysMap.put('i', new int[]{0,7});
            keysMap.put('o', new int[]{0,8});
            keysMap.put('p', new int[]{0,9});

            keysMap.put('h', new int[]{1,5});
            keysMap.put('j', new int[]{1,6});
            keysMap.put('k', new int[]{1,7});
            keysMap.put('l', new int[]{1,8});

            keysMap.put('b', new int[]{2,4});
            keysMap.put('n', new int[]{2,5});
            keysMap.put('m', new int[]{2,6});
        }

    }
}
