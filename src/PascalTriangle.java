import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;


public class PascalTriangle
{
    public static void main( String[] args )
    {
        int row = 10;
        int[][] a = new int[10][10] ;
        for(int i=0 ; i< row ; i++){
            for(int j=0;j<=i;j++){
                if(j==0) a[i][j] = 1;
                else a[i][j] = a[i-1][j-1]+a[i-1][j];
            }
        }

       /* for(int k =0 ; k<a.length; k++  ){
            for(int l=0; l< a.length; l++){
                System.out.print(a[k][l]+" ");
            }
            System.out.println();
        }*/

        //formatting    for(int k =0 ; k< )
        for(int m=0; m < a.length ; m++){
            for(int n =row-1 ; n >= 0 ; n--) {
                if ( a[m][n] == 0 )
                    System.out.printf( " " );
                else
                    System.out.print( a[m][n] + " " );
            }
            System.out.println();
        }

    }
}
