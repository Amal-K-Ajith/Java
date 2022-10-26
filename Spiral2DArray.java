//  Program to print or get an spiral 2D array of size N*N
public class Spiral2DArray {
    public static void main(String[] args) {
        Spiral2DArray s=new Spiral2DArray();
        for(int i[]:s.generateMatrix(5)){
            for(int j:i)
                System.out.print(j+" ");
            System.out.println();
        }
        
    }
    public int[][] generateMatrix(int A) {
        int row=0,col=0,ele=1;
        int ans[][]=new int[A][A];
        if(A==1){
            ans[0][0]=1;
            return ans;
        }
        while(A>1){
            for(int i = 1;i<A;i++){
                ans[row][col] = ele++;
                col++;
            }
            for(int i = 1;i<A;i++){
                ans[row][col] = ele++;
                row++;
            }
            for(int i = 1;i<A;i++){
                ans[row][col] = ele++;
                col--;
            }
            for(int i = 1;i<A;i++){
                ans[row][col] = ele++;
                row--;
            }
            row++;
            col++;//Both went over the boundary so bringing back to next inside matrix
            A= A-2;//-2 because both sides are already populated
        }
        if(A==1)
         ans[row][col]=ele; //IF a IS Odd we need to give value to the center element too that y this line exist
        return ans;
    }
}
