public class Stu{

    public static void main(String []args){
        int [] circularArr = { 50,60,0,0,0,20,30,40 };
        circularArr = reverse (circularArr,5,5);
        print(circularArr,5,5);
        
     }
     
     
    public static int [] reverse(int [] source, int start, int size){
         int startInd=start;
         int lastValInd=(start+size-1)%source.length;
         int sourceSize=size;
         for(int i=0;i<=(size/2);i++){
             int temp = source[startInd];
             source[startInd] = source[lastValInd];
             source[lastValInd]=temp;
             startInd=(startInd+1)%source.length;
             sourceSize--;
             lastValInd=(start+sourceSize-1)%source.length;
             
             
             
         }
         
         return source;
     }
    
    public static void print(int[] source, int start, int size){
        int index= start;
        for(int i=0;i<size;i++){
            System.out.println(source[index]);
            index=(index+1)%source.length;
        }
    }
}