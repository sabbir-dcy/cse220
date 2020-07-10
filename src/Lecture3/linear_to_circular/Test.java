public class Test {
  static int q;
    public static void main(String[] args) {
        int[] x = {10,20,30,40,50,0,0,0,0,0};
        circularArray(x,4);
        for(int i : x)
            System.out.print(i + " ");
    }
    public static void rightShift(int[]j,int s) {
        for(int i=j.length-1; i>0; i--) {
            j[i] = j[i-1];
            q++;
        }
        j[0] = s;
    }

    public static void leftShift(int[] j, int s) {
        for (int i = 1; i < j.length; i++) {
            j[i - 1] = j[i];
            q++;
        }
        j[j.length - 1] = s;
    }
    public static void circularArray(int[]j, int c) {
        boolean changed = false;
        if (c > j.length / 2) {
            c = j.length - c;
            changed = true;
        }
        for(int i=0; i<c; i++) {
          q++;
          if (changed) {
              leftShift(j, j[0]);
          }
          else {
            rightShift(j,j[j.length-1]);
          }
        }
        System.out.println(q);
    }
} 