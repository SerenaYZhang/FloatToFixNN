import java.util.*;
import java.math.BigInteger;
public class MyClass {
    public static void main(String args[]) {
        System.out.println(fibCypher('E', 3, 7, 'h', "ACSL Sr-5 c2"));
        System.out.println(fibCypher('D', 3, 7, 'h', "386 358 425 415 347 419 405 402 377 377 390 416"));
    }
    
    public static String fibCypher(char option, int num1, int num2, char key, String msg) {
        if (msg.length()==0){
            return "";
        }
        if (option=='E'){
            return encode(num1, num2, (int) key, msg);
        } else {
            String[] strMsg = msg.split(" ");
            //System.out.println(Arrays.toString(strMsg));
            if (strMsg.length<105){
                long[] intMsg = new long[strMsg.length];
                for (int i=0; i<strMsg.length; i++){
                    intMsg[i] = Long.parseLong(strMsg[i]);
                }
                return decode(num1, num2, (int) key, intMsg);
            } else {
                BigInteger[] intMsg = new BigInteger[strMsg.length];
                for (int i=0; i<strMsg.length; i++){
                    intMsg[i] = new BigInteger(strMsg[i]);
                }
                return decodeBig(new BigInteger("" + num1), new BigInteger("" + num2), new BigInteger("" + (int) key), intMsg);
            }
        }
    }
    
    public static String encode(long num1, long num2, long key, String msg){
        long offset = key + (num1 % 26);
        if (offset>122){
            offset = 97 + (offset - 123);
        }
        String ans = (long) (msg.charAt(0) + 3 * offset) + "";
        if (msg.length()==1){
            return ans;
        }
        offset = key - (num2 % 26);
        if (offset<97){
            offset = 122 - (96 - offset);
        }
        ans += " " + (long) (msg.charAt(1) + 3 * offset);
        for (int i=2; i<msg.length(); i++){
            long fibSum = num1 + num2;
            if (i%2==0){
                offset = key + (fibSum % 26);
                if (offset>122){
                    offset = 97 + (offset - 123);
                }
                ans += " " + (long) (msg.charAt(i) + 3 * offset);
            } else {
                offset = key - (fibSum % 26);
                if (offset<97){
                    offset = 122 - (96 - offset);
                }
                ans += " " + (long) (msg.charAt(i) + 3 * offset);
            }
            num1 = num2;
            num2 = fibSum;
        }
        return ans;
    }
    
    public static String decode(long num1, long num2, long key, long[] msg){
        long offset = key + (num1 % 26);
        if (offset>122){
            offset = 97 + (offset - 123);
        }
        String ans = (char) (msg[0] - 3 * offset) + "";
        if (msg.length==1){
            return ans;
        }
        offset = key - (num2 % 26);
        if (offset<97){
            offset = 122 - (96 - offset);
        }
        ans += (char) (msg[1] - 3 * offset);
        for (int i=2; i<msg.length; i++){
            long fibSum = num1 + num2;
            if (i%2==0){
                offset = key + (fibSum % 26);
                if (offset>122){
                    offset = 97 + (offset - 123);
                }
                ans += (char) (msg[i] - 3 * offset);
            } else {
                offset = key - (fibSum % 26);
                if (offset<97){
                    offset = 122 - (96 - offset);
                }
                ans += (char) (msg[i] - 3 * offset);
            }
            num1 = num2;
            num2 = fibSum;
        }
        return ans;
    }
    
    public static String decodeBig(BigInteger num1, BigInteger num2, BigInteger key, BigInteger[] msg){
        BigInteger numAlp = new BigInteger("26");
        BigInteger three = new BigInteger("3");
        BigInteger aASCII = new BigInteger("97");
        BigInteger aLessASCII = new BigInteger("96");
        BigInteger zASCII = new BigInteger("122");
        BigInteger zGreaterASCII = new BigInteger("123");
        String ans = "";
        BigInteger offset0 = new BigInteger("" + key.add(num1.mod(numAlp)));
        if (offset0.compareTo(zASCII)>0){
            BigInteger newOffset = aASCII.add(offset0.subtract(zGreaterASCII));
            BigInteger ASCII = msg[0].subtract(newOffset.multiply(three));
            ans += (char) (ASCII.intValue());
        } else {
            BigInteger ASCII = msg[0].subtract(offset0.multiply(three));
            ans += (char) (ASCII.intValue());
        }
        BigInteger offset1 = new BigInteger("" + key.subtract(num2.mod(numAlp)));
        if (offset1.compareTo(aASCII)<0){
            BigInteger newOffset = zASCII.subtract(aLessASCII.subtract(offset1));
            BigInteger ASCII = msg[1].subtract(newOffset.multiply(three));
            ans += (char) (ASCII.intValue());
        } else {
            BigInteger ASCII = msg[1].subtract(offset1.multiply(three));
            ans += (char) (ASCII.intValue());
        }
        ArrayList<BigInteger> fibList = new ArrayList<BigInteger>(200);
        fibList.add(num1);
        fibList.add(num2);
        for (int i=2; i<msg.length; i++){
            BigInteger fibSum = fibList.get(i-2).add(fibList.get(i-1));
            fibList.add(fibSum);
            if (i%2==0){
                BigInteger offset = new BigInteger("" + key.add(fibSum.mod(numAlp)));
                if (offset.compareTo(zASCII)>0){
                    BigInteger newOffset = aASCII.add(offset.subtract(zGreaterASCII));
                    BigInteger ASCII = msg[i].subtract(newOffset.multiply(three));
                    ans += (char) (ASCII.intValue());
                } else {
                    BigInteger ASCII = msg[i].subtract(offset.multiply(three));
                    ans += (char) (ASCII.intValue());
                }
            } else {
                BigInteger offset = new BigInteger("" + key.subtract(fibSum.mod(numAlp)));
                if (offset.compareTo(aASCII)<0){
                    BigInteger newOffset = zASCII.subtract(aLessASCII.subtract(offset));
                    BigInteger ASCII = msg[i].subtract(newOffset.multiply(three));
                    ans += (char) (ASCII.intValue());
                } else {
                    BigInteger ASCII = msg[i].subtract(offset.multiply(three));
                    ans += (char) (ASCII.intValue());
                }
            }
        }
        return ans;
    }
}
