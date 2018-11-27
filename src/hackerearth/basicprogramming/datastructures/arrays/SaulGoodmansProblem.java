package hackerearth.basicprogramming.datastructures.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/saul-goodmans-problem-statement/description/
 */
public class SaulGoodmansProblem
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader bf = new BufferedReader( new InputStreamReader( System.in ) );
        int t = Integer.parseInt( bf.readLine().trim() );

        for(int i=0; i< t; i++){
            List<Pair> pairs = new ArrayList<>(  );
            int tc = Integer.parseInt( bf.readLine().trim() );
            int tcc = 1;

            //get the first true cells and check if they fall in same diagonal
            Pair p1 = new Pair(bf.readLine().trim().split( " " ));
            Pair p2 = new Pair(bf.readLine().trim().split( " " ));

            if(p1.isInSameDiagonal( p2 )) {
                pairs.add( p1 );
                tcc++ ;
            } else{
                pairs.add( p1 );
                pairs.add( p2 );
            }

            for(int j=2; j< tc; j++){
                Pair p3 = new Pair(bf.readLine().trim().split( " " ));
                Iterator it = pairs.iterator();
                List<Pair> addPairs = new ArrayList<>(  );
                while ( it.hasNext() ){
                    if(p3.isInSameDiagonal( (Pair) it.next() )) {
                        tcc++;
                        break;
                    }
                    else addPairs.add( p3 );

                }
                pairs.addAll( addPairs );
            }

            if(tcc == 1)
                System.out.println(0);
            else
                System.out.println(tcc);
        }

    }

}

class Pair{
    private int x;
    private int y;


    public Pair( String[] s )
    {
        this.x = Integer.parseInt( s[0] );
        this.y = Integer.parseInt( s[1] );
    }


    public int getX()
    {
        return x;
    }


    public void setX( int x )
    {
        this.x = x;
    }


    public int getY()
    {
        return y;
    }


    public void setY( int y )
    {
        this.y = y;
    }


    boolean isInSameDiagonal(Pair p){
        return this.x - p.x == this.y - p.y;
    }
}
