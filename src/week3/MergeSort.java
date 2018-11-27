package week3;

import java.util.Arrays;


public class MergeSort
{
    public static void main( String[] args )
    {
        Integer[] a = new Integer[] {1,3,2 ,4 };
        System.out.println("Before Merge sort : "+ Arrays.toString( a ));
        sort( a  );
        System.out.println("After Merge sort : "+ Arrays.toString( a ));
    }

    static <T extends Comparable<? super T>> void  sort(T [] a){
        T [] aux  = (T[]) new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }


    private  static <T extends Comparable<? super T>> void sort( T[] a, T[] aux, int low, int high ) {
        if(high <= low) return;
        else{
            int mid = (low + high)/2;
            sort( a, aux, low, mid );
            sort( a, aux, mid+1, high );
            merge(a, aux, low, mid, high);
        }
    }


    private static <T extends Comparable<? super T>> void merge( T[] a, T[] aux, int low, int mid, int high ) {
        for(int k = low; k <= high; k++){
            aux[k] = a[k];
        }
        int i= low;
        int j= mid+1;

        for(int k = low ; k<= high; k++){
            if( i > mid ) a[k] = aux[j++];
            else if( j > high ) a[k] = aux[i++];
            else if(aux[j].compareTo( aux[i] ) < 0 ) a[k] = aux[j++];
            else a[k] = aux[i++];

        }
    }
}
