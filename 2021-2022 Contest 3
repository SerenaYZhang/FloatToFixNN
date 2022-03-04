import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        long fibNumber = 89;
        System.out.println(countUniqueValues(fibNumber));
    }
    
    public static int countUniqueValues(long fibNumber){
        ArrayList<ArrayList<Long>> fibSequence = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> row1 = new ArrayList<Long>();
        row1.add(1L);
        ArrayList<Long> row2 = new ArrayList<Long>();
        row2.add(1L);
        row2.add(1L);
        fibSequence.add(row1);
        fibSequence.add(row2);
        int numRows = 2;
        long prevSum = 1;
        long sum = 1;
        while(sum<fibNumber){
            numRows++;
            sum += prevSum;
            prevSum = sum - prevSum;
        }
        System.out.println("numRows " + numRows + "     sum " + sum);
        HashSet<Long> numSet = new HashSet<Long>();
        HashSet<Long> repeatNumSet = new HashSet<Long>();
        numSet.add(1L);
        repeatNumSet.add(1L);
        for (int i=2; i<(numRows+1)/2; i++){
            ArrayList<Long> prevRow = fibSequence.get(i-1);
            ArrayList<Long> rowI = new ArrayList<Long>(i);
            rowI.add(1L);
            for (int j=0; j<i-1; j++){
                Long num = prevRow.get(j)+prevRow.get(j+1);
                rowI.add(num);
                if (numSet.contains(num)){
                    repeatNumSet.add(num);
                }
                numSet.add(num);
            }
            rowI.add(1L);
            fibSequence.add(rowI);
        }
        int rowSize = (numRows + 1) / 2;
        System.out.println("rowSize " + rowSize);
        if (numRows%2==1){
            rowSize--;
        }
        for (int i=(numRows+1)/2; i<numRows; i++){
            ArrayList<Long> prevRow = fibSequence.get(i-1);
            ArrayList<Long> rowI = new ArrayList<Long>(i);
            rowI.add(1L);
            for (int j=0; j<rowSize-1; j++){
                Long num = prevRow.get(j)+prevRow.get(j+1);
                rowI.add(num);
                if (numSet.contains(num)){
                    repeatNumSet.add(num);
                }
                numSet.add(num);
            }
            fibSequence.add(rowI);
            rowSize--;
        }
        System.out.println("fibSequence " + fibSequence);
        System.out.println("numSet " + numSet + "     repeatNumSet " + repeatNumSet);
        return(numSet.size() - repeatNumSet.size());
    }
}
