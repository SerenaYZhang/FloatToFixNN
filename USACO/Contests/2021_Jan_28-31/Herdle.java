import java.io.*;
import java.util.*;
import java.lang.*;
/*
ID: 5erenazhang
LANG: JAVA
TASK: Herdle
*/
public class Herdle {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        char[][] correctGrid = new char[3][3];
        char[][] guessGrid = new char[3][3];
        for (int i=0; i<3; i++){
            String line = f.readLine();
            correctGrid[i][0] = line.charAt(0);
            correctGrid[i][1] = line.charAt(1);
            correctGrid[i][2] = line.charAt(2);
        }
        int green = 0;
        boolean[][] greenPlaces = new boolean[3][3];
        for (int i=0; i<3; i++){
            String line = f.readLine();
            for (int j=0; j<3; j++){
                char cow = line.charAt(j);
                if (cow==correctGrid[i][j]){
                    green++;
                    greenPlaces[i][j] = true;
                }
                guessGrid[i][j] = cow;
            }
        }
        int yellow = 0;
        boolean[][] yellowPlaces = new boolean[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (!greenPlaces[i][j]){
                    char guessCow = guessGrid[i][j];
                    outerloop:
                    for (int a=0; a<3; a++){
                        for (int b=0; b<3; b++){
                            if (guessCow==correctGrid[a][b] && !greenPlaces[a][b] && !yellowPlaces[a][b]){
                                yellow++;
                                yellowPlaces[a][b] = true;
                                break outerloop;
                            }
                        }
                    }
                }
            }
        }
        out.println(green);
        out.println(yellow);
        out.close();
    }
}
