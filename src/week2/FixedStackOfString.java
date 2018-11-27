package week2;

public class FixedStackOfString {
    private String[] strings;
    int n= 0;

    public FixedStackOfString(int maxCapatity) {
        strings = new String[maxCapatity];
    }

    public void push(String item) {
        strings[n++] = item;
    }

    public String pop() {
        String item= strings[--n];
        strings[n] = null;
        return item;
    }
}
