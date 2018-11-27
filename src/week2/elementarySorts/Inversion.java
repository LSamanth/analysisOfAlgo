package week2.elementarySorts;

public class Inversion
{
    public void sort(Comparable a[]) {
        int n = a.length;
        for(int i =0 ; i< n; i++){
            for(int j=i; j >=0 ; j--){
                if(less( a[j] , a[j-1]  ))
                    exchange( a, j, j-1 );
            }
        }
    }

    private void exchange( Comparable[] a, int i, int j )
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less( Comparable i, Comparable j )
    {
        if(i.compareTo( j ) < 0) return true;
        else return false;
    }
}
