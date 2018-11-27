package hackerearth.basicprogramming;

import java.util.Scanner;


public class AliHelpsPeople
{
    /*Arpasland has surrounded by attackers. A truck enters the city. The driver
    claims the load is food and medicine from Iranians. Ali is one of the soldiers
     in Arpasland. He doubts about the truck, maybe it's from the siege. He knows
     that a tag is valid if the sum of every two consecutive digits of it is even
     and its letter is not a vowel. Determine if the tag of the truck is valid or not.

    We consider the letters "A","E","I","O","U","Y" to be vowels for this problem.

    Input Format

    The first line contains a string of length 9.
    The format is "DDXDDD-DD", where D stands for a digit (non zero)
    and X is an uppercase english letter.*/


    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        String tag = s.nextLine();                 // Reading input from STDIN

        char letter = tag.charAt( 2 );
        boolean isVowel = letter == 'A'|| letter == 'E' || letter == 'I'||
            letter == 'O' || letter == 'U' || letter == 'Y';

        boolean isEven1 = (Integer.parseInt( String.valueOf( tag.charAt( 0  ))) +
            Integer.parseInt( String.valueOf( tag.charAt( 1  ) ) )) %2 == 0;

        boolean isEven2 = (Integer.parseInt( String.valueOf( tag.charAt( 3  ))) +
            Integer.parseInt( String.valueOf( tag.charAt( 4  ) ) )) %2 == 0;

        boolean isEven3 = (Integer.parseInt( String.valueOf( tag.charAt( 4  ))) +
            Integer.parseInt( String.valueOf( tag.charAt( 5  ) ) )) %2 == 0;

        boolean isEven4 = (Integer.parseInt( String.valueOf( tag.charAt( 7  ))) +
            Integer.parseInt( String.valueOf( tag.charAt( 8  ) ) )) %2 == 0;

        if(isEven1  && !isVowel && isEven2 && isEven3 && isEven4 )
            System.out.println("valid");
        else
            System.out.println("invalid");
    }


}
