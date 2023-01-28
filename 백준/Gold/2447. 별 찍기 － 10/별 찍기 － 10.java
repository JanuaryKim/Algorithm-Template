import java.io.*;

public class Main {
    static String[][] arr = null;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        arr = new String[size][size];

        star(0, 0, size);

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                bw.write(arr[i][j] != null ? arr[i][j] : " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void star(int x, int y, int size) {
        if(size == 1){
            arr[x][y] = "*";
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){        
                if(!(i==1 && j==1))
                    star(x + i*size/3, y + j*size/3, size/3);
            }
        }
    }
}
