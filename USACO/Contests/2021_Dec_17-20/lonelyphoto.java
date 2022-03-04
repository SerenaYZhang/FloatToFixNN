import java.io.*;
import java.util.*;
import java.lang.*;
/*
ID: 5erenazhang
LANG: JAVA
TASK: lonelyphoto
*/
public class lonelyphoto {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        String line = f.readLine();
        long count = 0;
        for (int i=0; i<N-2; i++){
            System.out.println("i " + i);
            int g = 0;
            int h = 0;
            int newI = i + 1;
            for (int j=i; j<i+3; j++){
                if (line.charAt(j)=='G'){
                    g++;
                } else {
                    h++;
                }
            }
            if (g==1 || h==1){
                count++;
            }
            int index = i + 3;
            if (g==3 || h==3){
                char letter = line.charAt(i);
                for (int j=i+3; j<N; j++){
                    if (letter!=line.charAt(j)){
                        if (line.charAt(j)=='G'){
                            g++;
                        } else {
                            h++;
                        }
                        count += j - i - 1;
                        if (j==N-1){
                            newI = j;
                        } else {
                            newI = j - 1;
                        }
                        break;
                    } else if (j==N-1){
                        newI = j;
                    }
                }
                index = newI + 2;
            }
            if (newI!=N-1){
                while ((g<=1 || h<=1) && index<N){
                    //System.out.println(i + " " + index);
                    if (line.charAt(index)=='G'){
                        g++;
                    } else {
                        h++;
                    }
                    if (g==1 || h==1){
                        count += newI - i;
                    }
                    index++;
                }
            }
            i = newI - 1;
        }
        out.println(count);
        out.close();
    }
}
