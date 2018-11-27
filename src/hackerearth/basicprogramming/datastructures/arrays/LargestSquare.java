package hackerearth.basicprogramming.datastructures.arrays;

/**
 * https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/largest-square-3d7a938a/
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


/**
 * Idea,
 * For the given points store the points in a map with key as x cordinate
 * and its corresponding y-points as its value in a set.
 *
 * Sample Input      Output
 *
 *    6                1 1
     1 1
     3 1
     5 1
     1 3
     3 3
     5 3

  So we'll store it as 1 -> 1,3 and 3-> 1,3 and 5 -> 1,3

 now we'll iterate the map for given x and y cordinates

 (1,1) and (1,3) -> length is  y2-y1 = 2 so x2 should be 3
 Now we have a key with value 3 in our map so now verify if 1 and 3 are prepsent
 in its set of y's so that it forms a square

 */
public class LargestSquare
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader bf = new BufferedReader( new InputStreamReader( System.in ) );
        int inputs = Integer.parseInt( bf.readLine() );

        int ms = 0;
        int mx = 0, my =0 ;

        final Map<Integer, Set<Integer>> xys = createInputMap( bf, inputs );

       // System.out.println(xys);
        for( Entry<Integer, Set<Integer>> in : xys.entrySet()){
            int x1 = in.getKey();
            int[] ys= in.getValue().stream().mapToInt( x -> x ).toArray();
            for(int y1= 0; y1 < ys.length ; ++y1){
                for(int y2= y1+1; y2< ys.length ; ++y2){
                    int size = (ys[y2]-ys[y1]);
                   int x2 = x1+size;
                   if(size < ms || (size == ms && ys[y1]>= my  )) continue;
                   Set<Integer> x2ys = xys.get( x2 );
                   if( x2ys!= null && x2ys.contains( ys[y1] ) && x2ys.contains( ys[y2] )){
                       ms = size;
                       mx = x1;
                       my = ys[y1];
                   }
                }
            }
        }

        if(mx > 0 && my > 0)
            System.out.println(mx+" "+my);
        else
            System.out.println(-1);

    }


    private static Map<Integer, Set<Integer>> createInputMap( BufferedReader bf, int inputs )
        throws IOException
    {
        Map<Integer, Set<Integer>> inputMap = new TreeMap<>();
        for(int i=0; i< inputs; i++){
            String[] c = bf.readLine().split( " " );
                int x = Integer.parseInt( c[0] );
                Set<Integer> existing = inputMap.get( x  );
                if(existing == null){
                    existing = new TreeSet();
                    existing.add( Integer.parseInt( c[1] ) );
                    inputMap.put( x, existing);
                }
                existing.add( Integer.parseInt( c[1] ) );
                inputMap.put( x,existing );
        }
        return inputMap;
    }

}
