import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//2621
public class Main {
    public static void main(String[] args) throws IOException {
        int maxScore = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Card[] cards = new Card[5];
        for(int i = 0; i < 5; i++) {
            String line = bf.readLine();
            cards[i] = new Card(line.charAt(2) - '0',line.charAt(0));
        }

        Arrays.sort(cards, Comparator.comparingInt(c -> c.num));

        for(int i = 1; i <= 9; i++){
            int tempScore = getScore(i, cards);
            if(tempScore > maxScore){
                maxScore = tempScore;
                break;
            }
        }
        System.out.println(maxScore);
    }

    private static int getScore(int type, Card[] cards){

        int score = 0;
        boolean check = true;
        switch (type){
            case 1:
                char c = cards[0].color;
                int n = cards[0].num;
                for(int i = 1; i < 4; i++){
                    if(c != cards[i].color){
                        check = false;
                        break;
                    }
                    if(n - cards[i].num != -1){
                        check = false;
                        break;
                    }
                    n = cards[i].num;
                }

                if(!check) break;

                score = 900 + cards[4].num;
                break;
            case 2:
                int checkNum = cards[0].num;
                for(int j = 0; j < 4; j++){
                    if(checkNum != cards[j].num)
                    {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    score = 800 + cards[1].num;
                    break;
                }

                checkNum = cards[4].num;
                for(int j = 4; j > 0; j--){
                    if(checkNum != cards[j].num)
                    {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    score = 800 + cards[1].num;
                }
                break;
            case 3:
                if((cards[0].num == cards[1].num) && (cards[2].num == cards[3].num && cards[3].num == cards[4].num))
                    score = 700 + (cards[2].num * 10) + cards[0].num;
                else if((cards[0].num == cards[1].num && cards[1].num == cards[2].num) && (cards[3].num == cards[4].num))
                    score = 700 + (cards[0].num * 10) + cards[3].num;
                break;
            case 4:
                for(int i = 1; i < 5; i++){
                    if(cards[0].color != cards[i].color){
                        check = false;
                        break;
                    }
                }
                if(check) score = 600 + cards[4].num;
                break;
            case 5:
                for(int i = 1; i < 5; i++){
                    if(cards[i-1].num - cards[i].num != -1) {
                        check = false;
                        break;
                    }
                }
                if(check) score = 500 + cards[4].num;
                break;
            case 6:
                if(cards[0].num == cards[1].num && cards[1].num == cards[2].num)
                    score = 400 + cards[0].num;
                else if(cards[1].num == cards[2].num && cards[2].num == cards[3].num)
                    score = 400 + cards[1].num;
                else if(cards[2].num == cards[3].num && cards[3].num == cards[4].num)
                    score = 400 + cards[2].num;
                break;
            case 7:
                if((cards[0].num == cards[1].num)&&(cards[2].num == cards[3].num))
                    score = 300 + (cards[3].num * 10) +  cards[0].num;
                else if((cards[1].num == cards[2].num)&&(cards[3].num == cards[4].num))
                    score = 300 + (cards[3].num * 10) +  cards[1].num;
                
                else if((cards[0].num == cards[1].num)&&(cards[3].num == cards[4].num))
                    score = 300 + (cards[3].num * 10) +  cards[0].num;
                break;
            case 8:
                if(cards[0].num == cards[1].num)
                    score = 200 + cards[0].num;
                else if(cards[1].num == cards[2].num)
                    score = 200 + cards[1].num;
                else if(cards[2].num == cards[3].num)
                    score = 200 + cards[2].num;
                else if(cards[3].num == cards[4].num)
                    score = 200 + cards[3].num;
                break;
            default:
                score = 100 + cards[4].num;
                break;
        }

        return score;
    }

    private static class Card{
        int num;
        char color;
        public Card(int num, char color){
            this.num = num;
            this.color = color;
        }
    }
}
