package hackerearth.basicprogramming.datastructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * There are a lot of Poke'mons who are jealous of the fact that they do NOT have any specialty, they're the... normal type of Poke'mon. But, what they fail to realize is that their power is their normalcy, the ability to think, rationalize and then act.

 But, they do have an additional power... Poke'mons like Jigglypuff - which are normal, can figure out if a trainer is real or is a part of Team Rocket. And they need to use their power to a great extent.

 In an array, which consists of N elements, A1, A2, ..., AN, if a subarray has the total number of distinct elements as that of the original array, that determines the presence of Team Rocket.

 You've to help the normal type Poke'mons in figuring out the total number of subarrays having total number of distinct elements same as that of the original array.

 Input format:
 The first line of the input will consist of a single integer N. The next line will consist of N integers A1, A2, ... , AN.

 Output format: Output the answer to the problem.

 Constraints:
 1 ≤ N ≤ 2 * 105
 1 ≤ Ai ≤ 109


 5
 1 2 2 1 1   8
 */

public class TheNormalType
{
    public static void main( String[] args )
    {
        /*BufferedReader bf = new BufferedReader(new InputStreamReader( System.in ));
        int n = Integer.parseInt( bf.readLine() );
        int[] a = Arrays.stream( bf.readLine().split( " " ) )
            .mapToInt( x -> Integer.parseInt( x ) ).toArray();
        int result = 0;
        //find the unique elements in the array
        long c = Arrays.stream( a ).distinct().count();*/

        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        long c =0;
        long result =0l;
        int[] a = new int[n];
        HashSet<Integer> in = new HashSet<>(  );
        for(int k=0 ;k<n;k++){
            a[k] = s.nextInt();
        }

        for(int ai: a){
            in.add( ai );
        }

        c = in.size();

        if(c== 1) result = (long) (n*(n+1))/2;
        else if(c == n ) result = 1;
        else {
            for ( int i = 0; i < n; i++ ) {
                in.clear();
                in.add( a[i] );
                for ( int j = i + 1; j < n; j++ ) {
                    if(!in.contains(a[j]))
                    in.add( a[j] );
                    if ( c == in.size() ) {
                        result = result + n - j;
                        break;
                    }
                }
            }
        }

        System.out.println(result);

    }
}
