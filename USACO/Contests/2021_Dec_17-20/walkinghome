import java.io.*;
import java.util.*;
import java.lang.*;
/*
ID: 5erenazhang
LANG: JAVA
TASK: walkinghome
*/
public class walkinghome {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int subcase=0; subcase<T; subcase++){
            st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            char[][] graph = new char[N][N];
            for (int i=0; i<N; i++){
                String line = f.readLine();
                for (int j=0; j<N; j++){
                    graph[i][j] = line.charAt(j);
                }
            }
            //System.out.println("graph " + Arrays.toString(graph));
            int[] current = {1, 0};
            int[] end = {N-1, N-1};
            int[] numPaths = {0};
            if (graph[1][0]=='.'){
                dfs(1, 0, end, graph, K, 0, 'D', numPaths);
            }
            //out.println(numPaths[0]);
            current[0] = 0;
            current[1] = 1;
            if (graph[0][1]=='.'){
                dfs(0, 1, end, graph, K, 0, 'R', numPaths);
            }
            out.println(numPaths[0]);
        }
        out.close();
    }
    
    public static void dfs(int x, int y, int[] end, char[][] graph, int maxTurns, int turns, char direction, int[] numPaths){
        //System.out.println("end " + Arrays.toString(end));
        //System.out.println("current " + Arrays.toString(current));
        //System.out.println(path);
        if (x==end[0] && y==end[1]){
            numPaths[0]++;
        } else if (direction=='R'){
            // int[] newCurrent = Arrays.copyOf(current, current.length);
            if (turns<maxTurns && x<end[0]){
                //System.out.println("current " + Arrays.toString(current));
                if (graph[x+1][y]=='.'){
                    // current[0]++;
                    dfs(x+1, y, end, graph, maxTurns, turns+1, 'D', numPaths);
                }
            }
            if (turns<=maxTurns && y<end[1]){
                //System.out.println("current " + Arrays.toString(current));
                if (graph[x][y+1]=='.'){
                    // newCurrent[1]++;
                    dfs(x, y+1, end, graph, maxTurns, turns, 'R', numPaths);
                }
            }
        } else if (direction=='D'){
            // int[] newCurrent = Arrays.copyOf(current, current.length);
            if (turns<maxTurns && y<end[1]){
                //System.out.println("current " + Arrays.toString(current));
                if (graph[x][y+1]=='.'){
                    //current[1]++;
                    dfs(x, y+1, end, graph, maxTurns, turns+1, 'R', numPaths);
                }
            }
            if (turns<=maxTurns && x<end[0]){
                //System.out.println("current " + Arrays.toString(current));
                if (graph[x+1][y]=='.'){
                    // newCurrent[0]++;
                    dfs(x+1, y, end, graph, maxTurns, turns, 'D', numPaths);
                }
            }
        }
    }
}
