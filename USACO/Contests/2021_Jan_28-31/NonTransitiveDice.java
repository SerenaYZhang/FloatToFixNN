import java.io.*;
import java.util.*;
import java.lang.*;
/*
ID: 5erenazhang
LANG: JAVA
TASK: NonTransitiveDice
*/
public class NonTransitiveDice {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int testCase=0; testCase<N; testCase++){
            st = new StringTokenizer(f.readLine());
            int[] diceA = new int[4];
            for (int i=0; i<4; i++){
                diceA[i] = Integer.parseInt(st.nextToken());
            }
            int[] diceB = new int[4];
            for (int i=0; i<4; i++){
                diceB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(diceA);
            Arrays.sort(diceB);
            int compareAB = getComparison(diceA, diceB);
            int compareBA = getComparison(diceB, diceA);
            int[] winDice;
            int[] loseDice;
            if (compareAB>800){
                winDice = diceA;
                loseDice = diceB;
            } else if (compareBA>800){
                winDice = diceB;
                loseDice = diceA;
            } else {
                out.println("no");
                continue;
            }
            boolean nonTransitive = false;
            outerloop:
            for (int a=1; a<=10; a++){
                for (int b=1; b<=10; b++){
                    for (int c=1; c<=10; c++){
                        for (int d=1; d<=10; d++){
                            int[] diceC = {a, b, c, d};
                            Arrays.sort(diceC);
                            if (getComparison(diceC, winDice)>800 && getComparison(loseDice, diceC)>800){
                                //System.out.println(Arrays.toString(diceC));
                                nonTransitive = true;
                                break outerloop;
                            }
                        }
                    }
                }
            }
            if (nonTransitive){
                out.println("yes");
            } else {
                out.println("no");
            }
        }
        out.close();
    }
    
    /*public static int getComparison(int[] dice1, int[] dice2){
        int compare = 0;
        if (dice1[0]==dice2[0] && dice1[1]==dice2[1] && dice1[2]==dice2[2] && dice1[3]==dice2[3]){
            return 800;
        }
        for (int i=0; i<4; i++){
            int a = dice1[i];
            for (int j=0; j<4; j++){
                if (dice2[j]<a){
                    compare += 100;
                } else if (dice2[j]==a){
                    compare += 1;
                }
            }
        }
        return compare;
    }*/
    
    public static int getComparison(int[] dice1, int[] dice2){
        int m = 0; 
        int n = 16;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (dice1[i]>dice2[j]){
                    m++;
                } else if (dice1[i]==dice2[j]){
                    n--;
                }
            }
        }
        if (2*m>n){
            return 801;
        } else if (2*m==n){
            return 800;
        } else {
            return 799;
        }
    }
}
