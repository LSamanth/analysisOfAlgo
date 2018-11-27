package hackerearth.basicprogramming.datastructures.stringmanipulation;

/**
 * You are given a string S. You need to print all possible permutation of that string.

 Input Format

 First and only line contains a string whose permutations need to be displayed

 Output Format

 All possible permutations should be displayed in single line with single spaces between them

 Input    Output
 abc      abc acb bac bca cab cba

 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Idea -  keep the first element fixed and permute the rest all elements
 * For 3 elements (abc) keeps a fixed and permute 'bc' so we get 'abc' and 'acb'
 * Now swap the rest of the elements into the first place and continue the process again
 * bac -> bac and bca
 * cba -> cba and cab
 */


public class Permutations
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        String original = scanner.nextLine();

        List<String> permu = generatePermutations(original);

        for(String s : permu)
            System.out.print(s + " ");
    }


    private static List<String> generatePermutations( String s )
    {
        if(s.length() == 2)
            return  Arrays.asList( s , String.valueOf( s.charAt( 1 ) )+String.valueOf( s.charAt( 0 ) ) );
        else {
            char[] chars = s.toCharArray();
            List<String> permutations = new ArrayList<>(  );
            for(int i=0; i<s.length(); i++){
                //swap the character with the first character in the string
                char temp = chars[i];
                char c = chars[0];
                chars[0] = temp;
                chars[i] = c;
                String newString = String.valueOf( chars );
                permutations.addAll( generatePermutations(newString.substring( 1,newString.length() )  ).stream().map(x -> temp+x).collect(
                    Collectors.toList()) );
            }
            return permutations;
        }
    }

}
