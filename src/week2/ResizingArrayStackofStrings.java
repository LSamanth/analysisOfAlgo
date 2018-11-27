package week2;

public class ResizingArrayStackofStrings {
    String[] s = new String[1];
    int n= 0;

    public void push(String item){
        s[n++] = item;
        if(n == s.length)
            resize(2 * s.length );
    }

    public String pop() {
        String item= s[--n];
        s[n] = null;
        if(n == s.length/4) resize( s.length/2 );
        return item;
    }

    public void resize(int size){
        String [] newArray = new String[size];
        for(int i= 0; i< s.length; i++){
            newArray[i] = s[i];
        }
        s = newArray;
    }

}
