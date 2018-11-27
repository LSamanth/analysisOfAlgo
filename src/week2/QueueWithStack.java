package week2;

public class QueueWithStack {
    LinkedStackOfStrings s1= new LinkedStackOfStrings( );
    LinkedStackOfStrings s2 = new LinkedStackOfStrings( );

    public void enqueue(String item){
            s1.push( item );
    }

    public String dequeue(){
        //when the second queue is empty pop all the elements from
        //first queue and insert into the second
        if(s2.isEmpty()){
            while ( !s1.isEmpty() ){
                s2.push( s1.pop() );
            }
        }
        return s2.pop();
    }
}
