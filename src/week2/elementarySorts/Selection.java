package week2.elementarySorts;

public class Selection
{
    public void sort(Comparable a[]){
        int n= a.length;
        for(int i =0;  i<n ; i++ ) {
            int min = i;
                for(int j = i+1; j< n; j++ ){
                    if(less(min, a[j])){
                        min = j;
                    }
                }
            exchange(a,i,min);
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
