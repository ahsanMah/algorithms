import java.util.Iterator;

/**
 * Created by smaug on 1/2/17.
 */
public class LinkedStack<Item> implements Iterable<Item>{

    private class Node{
        Item item;
        Node next;
    }

    private class listIterator implements Iterator<Item>{

        Node current = top;

        public boolean hasNext(){ return current != null; }
        public Item  next(){
            Item data = current.item;
            current = current.next;
            return data;
        }
    }

    public Iterator<Item> iterator(){return new listIterator();}

    private Node top = null;

    public boolean isEmpty(){
        return top == null;
    }

    public Item pop(){
        Item data = top.item;
        top = top.next;
        return data;
    }

    public void push(Item data){
        Node old = top;
        top = new Node();
        top.item = data;
        top.next = old;
    }

}


