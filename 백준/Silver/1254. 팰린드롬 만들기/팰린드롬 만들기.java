import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1254
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String oriWord = bf.readLine();
        String newWord = "";
        for(int i = 0; i < oriWord.length(); i++){
            newWord += oriWord.charAt(i);
            if(i != oriWord.length()-1)
                newWord+=" ";
        }

        int middle = newWord.length() / 2;
        int left = middle - 1;
        int right = middle + 1;
        while(true){

            if(left  < 0 && right > newWord.length()-1)
                break;
            else if(right > newWord.length() - 1){
                newWord += newWord.charAt(left);
            }

            if(newWord.charAt(left) != newWord.charAt(right)){
                middle++;
                left = middle - 1;
                right = middle + 1;
            }
            else{
                left--;
                right++;
            }
        }
        newWord = newWord.replaceAll(" ", "");
        System.out.println(newWord.length());
    }
}
