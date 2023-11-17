import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String subS = s.substring(1, s.length() - 1);
        List<Integer[]> list = new ArrayList<>();
        boolean open = false;
        String temp = "";
        for(int i = 0; i < subS.length(); i++){
            char curC = subS.charAt(i);
            if(curC == '{') {
                open = !open;
            }
            else if(curC == '}')
            {
                open = !open;
                temp += curC;
                String subTemp = temp.substring(1, temp.length() - 1);
                list.add(Arrays.stream(subTemp.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new));
                temp = "";
            }  
            
            if(open){
                temp += curC;
            }
        }
        
        Collections.sort(list, (arr1, arr2) -> {
            return arr1.length - arr2.length;
        });
        
        Set<Integer> set = new LinkedHashSet();
        
        for(Integer[] arr : list){
            Arrays.stream(arr).forEach(i-> set.add(i));
        }
        
        Integer[] arr = set.toArray(new Integer[0]);
        
        return Arrays.stream(arr).mapToInt(i->i).toArray();
    }
}