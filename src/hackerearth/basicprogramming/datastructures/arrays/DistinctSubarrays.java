package hackerearth.basicprogramming.datastructures.arrays;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * Score of an array is defined as the number of unique elements in it. Let that be T. For all t, from 1 to T find the number of subarrays with score equal to t.

 Input Format:
 First line contains N, the size of the array.
 Next N lines contains the array elements.
 Output Format:
 Output the answer for all t in a new line.

     INPUT              OUTPUT
     5                      7
     2
     2
     1
     3
     3
 *
 *
 * Explanation
 *
 * IN THE GIVEN TEST CASE
 there are 3 unique elements. that is T here(=3)
 for t =1 subarrays are
 2 ,2 ,1 ,3, 3, 2 2,3 3 .. total 7
 for t=2; subarrays are
 2 1, 1 3 , 2 2 1, 1 3 3 .. total 4
 for t=3 subarrays are
 2 1 3 , 2 2 1 3 , 2 1 3 3 , 2 2 1 3 3 . total 4
 hence ans is
 7
 4
 4
 *
 */
public class DistinctSubarrays
{
    public static void main( String[] args ) throws IOException
    {
        PrintWriter out = new PrintWriter( System.out );
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int size = Integer.parseInt( br.readLine() );

        int [] a = new int[size];
        for(int i=0 ;i< size; i++)
            a[i] = Integer.parseInt( br.readLine() );

        int t = findDistintElements(a);


        for(int i = 1; i <= t; i++ ){
            if(i==1){
                out.println( size + splitArrayAndFindDistinct( a, size, i,  0) );
            } else
                System.out.println(splitArrayAndFindDistinct( a, size, i, 0 ));
        }
    }


    private static int splitArrayAndFindDistinct( int[] a, int subsize, int t,  int distinct )
    {
        if(subsize > 1 ){
            for ( int i = 0, j = i+subsize ; j < a.length+1; i++, j=i+subsize ) {
                ;
                if ( findDistintElements( Arrays.copyOfRange( a, i, j) ) == t )
                    distinct++;
            }
            return splitArrayAndFindDistinct( a, subsize-1, t, distinct );
        }
        else return distinct;
    }


    private static int findDistintElements( int[] a )
    {
        Set<Integer> set = new HashSet<>( a.length );
        for(int i : a){
            set.add( i );
        }

        return set.size();
    }
}
