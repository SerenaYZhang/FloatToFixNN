import java.io.*;
import java.util.*;
import java.lang.*;
/*
ID: 5erenazhang
LANG: JAVA
TASK: Drought
*/
public class Drought {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int testCase=0; testCase<T; testCase++){
            st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] cowHunger = new int[N];
            for (int i=0; i<N; i++){
                cowHunger[i] = Integer.parseInt(st.nextToken());
            }
            if (N==1){
                out.println(0);
                continue;
            } else if (N==2){
                out.println(cowHunger[0]==cowHunger[1] ? 0:-1);
                continue;
            }
            boolean equal = false;
            long steps = 0;
            while (!equal){
                equal = true;
                boolean change = false;
                for (int i=0; i<N-2; i++){
                    int hunger1 = cowHunger[i];
                    int hunger2 = cowHunger[i+1];
                    int hunger3 = cowHunger[i+2];
                    if (hunger1!=hunger2 || hunger1!=hunger3 || hunger2!=hunger3){
                        equal = false;
                    }
                    if (hunger1<hunger2 && hunger2>hunger3){
                        change = true;
                        steps += 2 * ((hunger2-hunger1) + (hunger2-hunger3));
                        int dif12 = hunger2 - hunger1;
                        int dif23 = hunger2 - hunger3;
                        cowHunger[i] -= dif23;
                        cowHunger[i+1] -= dif12 + dif23;
                        cowHunger[i+2] -= dif12;
                        if (cowHunger[i]<0 || cowHunger[i+1]<0 || cowHunger[i+2]<0){
                            change = false;
                            break;
                        }
                    } else if (hunger2==hunger3 && hunger1<hunger2){
                        change = true;
                        steps += 2 * (hunger2-hunger1);
                        cowHunger[i+1] = hunger1;
                        cowHunger[i+2] = hunger1;
                    } else if (hunger1==hunger2 && hunger3<hunger2){
                        change = true;
                        steps += 2 * (hunger2-hunger3);
                        cowHunger[i] = hunger3;
                        cowHunger[i+1] = hunger3;
                    }
                }
                if (!equal && !change){
                    steps = -1;
                    break;
                }
            }
            out.println(steps);
        }
        out.close();
    }
}
