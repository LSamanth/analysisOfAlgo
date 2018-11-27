package week3;

import java.util.Arrays;


public class MergeWithMinAuxArray
{
    public static void main( String[] args )
    {
        Integer[] a = new Integer[] {3,1,2,5, 6,4,-1,8};
        System.out.println("Before Merge sort : "+ Arrays.toString( a ));
        sort( a  );
        System.out.println("After Merge sort : "+ Arrays.toString( a ));
    }

    static <T extends Comparable<? super T>> void  sort(T [] a){
        T [] aux  = (T[]) new Comparable[a.length%2 == 0 ? a.length/2 : (a.length/2)+1 ];
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
        for(int k = low, l=0 ; k < mid+1; k++, l++){
            aux[l] = a[k];
        }
        int i= 0;
        int j= mid+1;

        for(int k = low ; k<= high; k++){
            if( i > mid-low ) a[k] = a[j++];
            else if( j > high ) {
                a[k] = aux[i];
                i++;
            }
            else if(a[j].compareTo( aux[i] ) < 0 ) a[k] = a[j++];
            else {
                a[k] = aux[i];
                i++;
            }

        }
    }
}
