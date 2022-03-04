public class MyClass {
    public static void main(String args[]) {
      //String cstr = "RWGBG";
      //String cstr = "RCMGB";
      String cstr = "YYYYY";
      int[] time = new int[]{0,0,0};
      int[] sizeAtIndex = new int[]{1,1,2,3,5};
      for (int i=0; i<cstr.length(); i++){
          int[] timeIndex = timeRank(cstr.substring(i,i+1));
          for (int j=0; j<timeIndex.length; j++){
              time[timeIndex[j]] += sizeAtIndex[i];
          }
      }
      System.out.println(time[0] + " " + time[1] + " " + time[2]);
      String reverseTime = "";
      int[] addTime = new int[]{0,0,0};
      for (int i=2; i>=0; i--){
          int n = time[i];
          if (i>0){
              n *= 5;
          }
          n += addTime[i];
          if (n>=60){
              while (n>=60){
                  n -= 60;
                  addTime[i-1] += 1;
              }
          }
          if (i==0 && n>=12){
              n -= 12;
          }
          if (n<10){
              reverseTime += "0" + n;
          } else {
              reverseTime += n;
          }
      }
      String correctTime = reverseTime.substring(4,6) + ":" + reverseTime.substring(2,4) + ":" + reverseTime.substring(0,2);
      System.out.println(correctTime);
    }
    public static int[] timeRank(String color){
        int[] time;
        if (color.equals("R")){
            time = new int[]{0};
        } else if (color.equals("G")){
            time = new int[]{1};
        } else if (color.equals("B")){
            time = new int[]{2};
        } else if (color.equals("Y")){
            time = new int[]{0,1};
        } else if (color.equals("M")){
            time = new int[]{0,2};
        } else if (color.equals("C")){
            time = new int[]{1,2};
        } else {
            time = new int[0];
        }
        return time;
    }
}
