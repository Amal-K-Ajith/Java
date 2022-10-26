/*  
    A wire connects N light bulbs.Each bulb has a switch associated with it; 
    however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
    Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
    You can press the same switch multiple times.
    
    Note: 0 represents the bulb is off and 1 represents the bulb is on.
*/
public class Bulbs {
    public static void main(String args[]){
      Bulbs b=new Bulbs();
      int A[]={0, 1, 0, 1};
      int B[]={1, 1, 1, 1};
      System.out.println(b.bulbs(A));
      System.out.println(b.bulbs(B));
    }
    public int bulbs(int[] A) {
        int count=0;
        for(int i:A){
           if( count%2==0 && i==1)continue;
           else if(count%2!=0 && i==0)continue;
           count++;
        }
        return count;
    }
}
