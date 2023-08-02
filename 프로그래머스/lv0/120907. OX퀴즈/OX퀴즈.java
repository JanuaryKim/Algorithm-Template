import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
     
        ArrayList<String> answerList = new ArrayList<>();
        for (String q : quiz) {
            String[] quizSplit = q.replaceAll("- -", "").replaceAll("- ", "-").replaceAll("[+] ", "").split(" ");
            if (Integer.parseInt(quizSplit[0]) + Integer.parseInt(quizSplit[1]) == Integer.parseInt(quizSplit[3])) {
                answerList.add("O");
            } else {
                answerList.add("X");
            }
        }
        String[] answer = answerList.toArray(new String[0]);
        return answer;
    }
}