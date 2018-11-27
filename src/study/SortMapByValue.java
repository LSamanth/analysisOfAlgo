package study;

import java.util.*;


public class SortMapByValue
{

    public static void main( String[] args )
    {
        Map<Integer, String> map = new HashMap<>(  );
        map.put( 1, "Ravi" );
        map.put( 2,"Suku" );
        map.put( 3, "mummy" );
        map.put( 4, "lavanya" );
        map.put( 5,"teja" );

        sort(map);
    }


    private static void sort( Map<Integer, String> map )
    {
        final Set<Map.Entry<Integer, String>> entries = map.entrySet();
        List<Map.Entry<Integer, String>> entryList = new ArrayList( entries );
        Collections.sort( entryList, new KeyComparator() );
        System.out.println("After sorting " + Arrays.toString( entryList.toArray() ));
    }

}

class KeyComparator implements Comparator<Map.Entry<Integer, String>>
{

    @Override public int compare( Map.Entry<Integer, String> m1, Map.Entry<Integer, String> m2 )
    {
        return m1.getValue().compareToIgnoreCase( m2.getValue() );
    }
}


