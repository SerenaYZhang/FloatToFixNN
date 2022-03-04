import java.io.*;
import java.util.*;
import java.lang.*;
/*
ID: 5erenazhang
LANG: JAVA
TASK: aircownditioning
*/
public class aircownditioning {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] preferedTemp = new int[N];
        int[] tempDiff = new int[N];
        st = new StringTokenizer(f.readLine());
        for (int i=0; i<N; i++){
            preferedTemp[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        for (int i=0; i<N; i++){
            tempDiff[i] = preferedTemp[i] - Integer.parseInt(st.nextToken());
        }
        int[] count = {0};
        ArrayList<Integer> indexTempChange = findIndexTempChange(tempDiff, 0, N);
        int start = 0;
        for (int i=0; i<indexTempChange.size()+1; i++){
            int end = N;
            if (i<indexTempChange.size()){
                end = indexTempChange.get(i);
            }
            findNumCommands(tempDiff, count, start, end);
            start = end;
        }
        out.println(count[0]);
        out.close();
    }
    
    public static void findNumCommands(int[] tempDiff, int[] count, int start, int end){
        //System.out.println("tempDiff " + Arrays.toString(tempDiff));
        //System.out.println("startIndex " + start + "     endIndex " + end);
        //System.out.println("count " + count[0]);
        if (end-start==1 && tempDiff[start]!=0){
            count[0] += Math.abs(tempDiff[start]);
            tempDiff[start] = 0;
        } else if (end-start>1 && tempDiff[start]!=0){
            int sign = tempDiff[start]/Math.abs(tempDiff[start]);
            int smallestChange = Math.abs(tempDiff[start]);
            for (int i=start; i<end; i++){
                if (Math.abs(tempDiff[i])<smallestChange){
                    smallestChange = Math.abs(tempDiff[i]);
                }
            }
            count[0] += smallestChange;
            for (int i=start; i<end; i++){
                tempDiff[i] -= smallestChange * sign;
            }
            int startIndex = start;
            ArrayList<Integer> indexTempChange = findIndexTempChange(tempDiff, start, end);
            //System.out.println("indexTempChange " + indexTempChange);
            for (int i=0; i<indexTempChange.size()+1; i++){
                int endIndex = end;
                if (i<indexTempChange.size()){
                    endIndex = indexTempChange.get(i);
                }
                findNumCommands(tempDiff, count, startIndex, endIndex);
                startIndex = endIndex;
            }
        }
    }
    
    public static ArrayList<Integer> findIndexTempChange(int[] tempDiff, int start, int end){
        ArrayList<Integer> indexTempChange = new ArrayList<Integer>();
        for (int i=start+1; i<end; i++){
            if (tempDiff[i-1]<=0 && tempDiff[i]>0 || tempDiff[i-1]>=0 && tempDiff[i]<0 || tempDiff[i-1]<0 && tempDiff[i]>=0 || tempDiff[i-1]>0 && tempDiff[i]<=0){
                indexTempChange.add(i);
            }
        }
        return indexTempChange;
    }
}
