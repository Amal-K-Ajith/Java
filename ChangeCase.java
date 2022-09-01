public class ChangeCase {

    public static void main(String[] args) {
        char[] c1={'A','b','C','d','E'};
        char[] c2={'A','b','C','d','E'};
        ChangeCase cc=new ChangeCase();
        cc.to_lower(c1);
        cc.to_upper(c2);
        System.out.println(c1);
        System.out.println(c2);
    }

    public char[] to_lower(char[] A) {
        for(int i=0;i<A.length;i++)
          if(A[i]>='A' & A[i]<='Z')A[i]=(char)(A[i]^(1<<5));
        // --------Since a=0110 0001 for all capital letters 5th bit is 0 so doing ^ set the bits--------
        return A;
    }
    public char[] to_upper(char[] A) {
        for(int i=0;i<A.length;i++)
         if(A[i]>='a' && A[i]<='z')A[i]=(char)(A[i]^(1<<5));
        return A;
    }
}
