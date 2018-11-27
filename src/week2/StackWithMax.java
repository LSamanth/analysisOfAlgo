package week2;

public class StackWithMax<T extends Comparable<? super  T>> {

    public Node first = null;
    private Node max = null;

    private class Node{
        T item;
        Node link;
    }

    public T pop(){
        T item = first.item;
        first = first.link;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.link = oldFirst;
        if(isEmpty())
            max = first;
        else{
            if(max.item.compareTo( first.item ) < 0)
                max = first;
        }
    }

    public T max(){
        return max.item;
    }
}