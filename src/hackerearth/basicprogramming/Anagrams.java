package hackerearth.basicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Given two strings, a and b , that may or may not be of the same length,
 * determine the minimum number of character deletions required to make a and b anagrams.
 * Any characters can be deleted from either of the strings.
 *
 * Note :Anagram of a word is formed by rearranging the letters of the word.

 For e.g. -> For the word RAM - MAR,ARM,AMR,RMA etc. are few anagrams.

 SAMPLE INPUT
 1
 cde
 abc

 SAMPLE OUTPUT
 4

 */


/**
 * Solution - We need to find min no.of deletions required to make the strings anagrams.
 * So put each character of the string in map and increment its count every time the character gets encountered.
 * The character with odd count are not eligible.Hence get the count of all keys withs odd count
 */

public class Anagrams
{
    public static void main(String args[] ) throws Exception {
       // Scanner s = new Scanner(System.in);
        //read the no of testcases to be run
        List<String> testCases = new ArrayList<>(  );
        //int totalTestCases = s.nextInt();
        //System.out.println(totalTestCases);
        /*String str;
        while ( !(str = s.nextLine()).isEmpty() ){
            System.out.println("here");
            testCases.add( str );
            while ( !(str = s.nextLine()).isEmpty() ) {
                testCases.add( testCases.get( testCases.size() - 1 ) + str );
                break;
            }
        }*/

        Scanner s = new Scanner(System.in);
        int  name =  s.nextInt();
        /*String st= s.nextLine(); //br.readLine();
        String u = s.nextLine();*/
        while (name !=0 ){
            String st= s.next().toLowerCase(); //br.readLine();
            String u = s.next().toLowerCase();

            Map<Character , Integer> m1= new HashMap<>(  );
            for(Character c: st.toCharArray()){
                Integer count = m1.get( c );
                if ( count != null )
                    m1.put( c, ++count );
                else
                    m1.put( c, 1 );
            }

            Map<Character , Integer> m2= new HashMap<>(  );
            for(Character c: u.toCharArray()){
                Integer count = m2.get( c );
                if ( count != null )
                    m2.put( c, ++count );
                else
                    m2.put( c, 1 );
            }

            System.out.println(m1.toString() + m2.toString());

            int deleteCount = 0;
            final Set<Map.Entry<Character, Integer>> entries = m1.entrySet();
            for ( Map.Entry<Character, Integer> entry : entries ) {
                if (  m2.get( entry.getKey()) == null  ){
                    deleteCount = deleteCount+ entry.getValue();

                }
                else{
                    deleteCount = deleteCount + Math.abs(entry.getValue() - m2.get( entry.getKey() ));
                    m2.remove( entry.getKey() );

                }
            }

            final Set<Map.Entry<Character, Integer>> entrie = m2.entrySet();
            for ( Map.Entry<Character, Integer> entry : entrie ) {
                deleteCount =  deleteCount+ entry.getValue();
            }

            System.out.println(deleteCount);

            name--;
        }


    }
}
