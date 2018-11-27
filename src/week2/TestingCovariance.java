package week2;

public class TestingCovariance<T> {
    public static void main( String[] args )
    {
        Integer[] ints = {1,2,3,4};
        Number[] nums = ints;
        nums[0] = 22.3;

        for(Number number: nums){
            System.out.println(number);
        }


    }

    public void testMethod(){
        T[] sts = (T[]) new Object[5];
    }
}
