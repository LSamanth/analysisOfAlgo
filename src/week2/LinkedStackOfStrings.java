package week2;

public class LinkedStackOfStrings {

    public Node first = null;

    private class Node{
        String item;
        Node link;
    }

    public String pop(){
        String item = first.item;
        first = first.link;
        return item;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.link = oldFirst;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public String last(){
        Node temp = first;
        while ( temp.link.link != null )
            temp = temp.link;
        String last = temp.item;
        temp.link = null;
        return last;
    }



}
