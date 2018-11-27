package hackerearth.basicprogramming.datastructures.stringmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


/**
 * Prashant started to attend programming lessons. On the first lesson his task was to write a simple program. The program was supposed to do the following: in the given string, consisting if uppercase and lowercase Latin letters, it:

 deletes all the vowels,
 inserts a character "." before each consonant,
 replaces all uppercase consonants with corresponding lowercase ones.
 Vowels are letters "A", "O", "Y", "E", "U", "I", and the rest are consonants. The program's input is exactly one string, it should return the output as a single string, resulting after the program's processing the initial string.

 Help Prashant cope with this easy task.

 Input First line of input contains an integer T number of test cases. The next T line represents input string of Prashant's program. This string only consists of uppercase and lowercase Latin letters and its length is from 1 to 100, inclusive.

 Output Print the resulting string. It is guaranteed that this string is not empty.

 Input  Output
 1       .d.n
 odn

 */
public class JumbleLetter
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader b = new BufferedReader( new InputStreamReader( System.in ) );
        int n = Integer.parseInt( b.readLine() );
        String s = null;

        // int temp= 0;
        Map<Character, Integer> vowelMap = new HashMap<>(  );
        vowelMap.put( 'a',1 );
        vowelMap.put( 'e', 1 );
        vowelMap.put( 'i', 1 );
        vowelMap.put( 'o', 1 );
        vowelMap.put( 'u', 1 );
        vowelMap.put( 'y',1 );
        vowelMap.put( 'A', 1 );
        vowelMap.put( 'E', 1 );
        vowelMap.put( 'I', 1 );
        vowelMap.put( 'O', 1 );
        vowelMap.put( 'U', 1 );
        vowelMap.put( 'Y', 1 );
        while ( n > 0 ){
            final String result ;
            s = b.readLine();
            //            for(char c : s.toCharArray() ){
            //                if( vowelMap.get(c) == null)
            //                {
            //                    if(c >=65 && c <=90){
            //                        temp = c+32;
            //                        c = (char) temp;
            //                    }
            //                    result = result + "." + c;
            //                }
            //            }


            //using java 8
            s.chars().forEach( c -> {
                char ch = (char) c;
                if(vowelMap.get( ch ) == null){
                    if(ch >=65 && ch <=90){
                        int temp = ch+32;
                        ch = (char) temp;
                    }

                    System.out.print("." + ch);
                }

            } );

            System.out.println();

            n--;
        }

    }
}
