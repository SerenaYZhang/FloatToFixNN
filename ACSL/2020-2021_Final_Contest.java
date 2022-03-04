import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String strPositions = scan.nextLine();
        String[] arrStrPositions = strPositions.split(" ");
        System.out.println(Arrays.toString(arrStrPositions));
        boolean[][] board = new boolean[8][8];
        int[] kingPosition = new int[2];
        for (int i=0; i<arrStrPositions.length; i++){
            int[] occupiedPosition = position(arrStrPositions[i].substring(1,3));
            board[occupiedPosition[0]][occupiedPosition[1]] = true;
            if (arrStrPositions[i].charAt(0)=='K'){
                kingPosition = occupiedPosition;
            }
        }
        for (int i=0; i<8; i++){
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println(Arrays.toString(kingPosition));
        boolean check = positionDangerous(arrStrPositions, kingPosition, board);
        System.out.println("check: " + check);
        int[][] kingNeighbors = neighbors(kingPosition);
        System.out.print("neighbors: ");
        for (int i=0; i<kingNeighbors.length; i++){
            System.out.print(Arrays.toString(kingNeighbors[i]));
        }
        System.out.println();
        boolean stalemate = true;
        for (int i=0; i<kingNeighbors.length; i++){
            boolean checkNeighbor = positionDangerous(arrStrPositions, kingNeighbors[i], board);
            if (!checkNeighbor){
                //System.out.println("False Neighbor: " + Arrays.toString(kingNeighbors[i]));
                stalemate = false;
                break;
            }
        }
        System.out.println("stalemate: " + stalemate);
        if (check && stalemate){
            System.out.println("Checkmate");
        } else if (check){
            System.out.println("Check");
        } else if (stalemate){
            System.out.println("Stalemate");
        } else {
            System.out.println("Safe");
        }
    }
    
    public static int[] position(String strPosition) {
        return new int[]{strPosition.charAt(0) - 'A', strPosition.charAt(1) - '1'};
    }
    
    public static int[][] neighbors(int[] kingPosition){
        int x = kingPosition[0];
        int xMin = x-1;
        int xMax = x+1;
        int y = kingPosition[1];
        int yMin = y-1;
        int yMax = y+1;
        if (x==0){
            xMin = x;
        } else if (x==7){
            xMax = x;
        }
        if (y==0){
            yMin = y;
        } else if (y==7){
            yMax = y;
        }
        int[][] neighborPositions = new int[(xMax-xMin+1)*(yMax-yMin+1)-1][2];
        int index = 0;
        for (int i=xMin; i<=xMax; i++){
            for (int j=yMin; j<=yMax; j++){
                if (i!=x || j!=y){
                    neighborPositions[index] = new int[]{i,j};
                    index++;
                }
            }
        }
        return neighborPositions;
    }
    
    public static boolean pawn(int[] pawnPosition, int[] targetPosition) {
        if (targetPosition[1] - pawnPosition[1] != 1) {
            return false;
        }
        int x_diff = pawnPosition[0] - targetPosition[0];
        return x_diff == 1 || x_diff == -1;
    }
    
    public static boolean knight(int[] knightPosition, int[] targetPosition){
        int knightX = knightPosition[0];
        int knightY = knightPosition[1];
        int targetX = targetPosition[0];
        int targetY = targetPosition[1];
        if (Math.abs(knightX-targetX)==1 && Math.abs(knightY-targetY)==2 || Math.abs(knightX-targetX)==2 && Math.abs(knightY-targetY)==1){
            return true;
        }
        return false;
    }
    
    public static boolean rook(int[] rookPosition, int[] targetPosition, boolean[][] board){
        int rookX = rookPosition[0];
        int rookY = rookPosition[1];
        int targetX = targetPosition[0];
        int targetY = targetPosition[1];
        if (rookX==targetX){
            for (int i=(rookY<targetY? rookY:targetY)+1; i<(rookY<targetY? targetY:rookY); i++){
                if (board[rookX][i]){
                    return false;
                }
            }
            return true;
        } else if (rookY==targetY){
            for (int i=(rookX<targetX? rookX:targetX)+1; i<(rookX<targetX? targetX:rookX); i++){
                if (board[i][rookY]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public static boolean bishop(int[] bishopPosition, int[] targetPosition, boolean[][] board){
        int bishopX = bishopPosition[0];
        int bishopY = bishopPosition[1];
        int targetX = targetPosition[0];
        int targetY = targetPosition[1];
        if (Math.abs(bishopX-targetX)!=Math.abs(bishopY-targetY)){
            return false;
        }
        if (bishopX-targetX==bishopY-targetY){
            for (int i=(bishopX<targetX? bishopX:targetX)+1; i<(bishopX<targetX? targetX:bishopX); i++){
                if (board[i][i]){
                    return false;
                }
            }
        } else {
            for (int i=(bishopX<targetX? bishopX:targetX)+1; i<(bishopX<targetX? targetX:bishopX); i++){
                if (board[i][bishopY-i]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean queen(int[] queenPosition, int[] targetPosition, boolean[][] board){
        if (rook(queenPosition, targetPosition, board) || bishop(queenPosition, targetPosition, board)){
            return true;
        }
        return false;
    }
    
    public static boolean positionDangerous(String[] arrStrPositions, int[] targetPosition, boolean[][] board){
        boolean check = false;
        for (int i=0; i<arrStrPositions.length; i++){
            char piece = arrStrPositions[i].charAt(0);
            int[] piecePosition = position(arrStrPositions[i].substring(1,3));
            if (piece=='P'){
                check = pawn(piecePosition, targetPosition);
                //System.out.println("Pawn " + check);
            } else if (piece=='R'){
                check = rook(piecePosition, targetPosition, board);
                //System.out.println("Rook " + check);
            } else if (piece=='N'){
                check = knight(piecePosition, targetPosition);
                //System.out.println("Knight " + check);
            } else if (piece=='B'){
                check = bishop(piecePosition, targetPosition, board);
                //System.out.println("Bishop " + check);
            } else if (piece=='Q'){
                check = queen(piecePosition, targetPosition, board);
                //System.out.println("Queen " + check);
            }
            if (check){
                return true;
            }
        }
        return false;
    }
}
//RG7 KE6 QB3 RD3 BA1
//ND2 PA3 BC3 KA4 PC5 RH5 NB6 BE8 QF8
