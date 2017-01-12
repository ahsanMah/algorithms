import java.util.Iterator;
import java.lang.Exception.*;
import java.util.NoSuchElementException;

/**
 * Created by smaug on 1/11/17.
 */
public class Deque<Item> implements Iterable<Item> {

    private class Node{
        Item item;
        Node next;
        Node prev;

        private Node(Item data, Node front, Node back){
            item = data;
            next = front;
            prev = back;
        }
    }

    private class dequeIterator implements Iterator<Item>{
        Node current = head;

        public Item next(){

            if (!hasNext()){throw new NoSuchElementException("Iterator is empty");}

            Item data = current.item;
            current = current.next;
            return data;
        }
        public boolean hasNext(){
            return current != null;
        }

        public void remove(){ throw new UnsupportedOperationException("Removing items through iterator is not allowed");}
    }

    private Node head;
    private Node tail;
    private int size;

    public Deque(){
        head = null;
        tail = null;
        size = 0;
    }

    public Iterator<Item> iterator(){return new dequeIterator();}

    public boolean isEmpty(){return size == 0;}
    public int size(){return size;}

    //Adds item to front of the deque
    public void addFirst(Item item){

        if (item == null) {throw new NullPointerException("Cannot add Null item to deque");}

        Node new_node = new Node(item,head, null);
        if (head == null){ //If first item to be added
            head = new_node;
            tail = head;
        }
        else{
            head.prev = new_node;
            head = head.prev;
        }
        size++;
    }

    //Adds item to end of the deque
    public void addLast(Item item){

        if (item == null) {throw new NullPointerException("Cannot add Null item to deque");}

        Node new_node = new Node(item,null, tail);
        if (tail == null){
            tail = new_node;
            head = tail;
        }
        else {
            tail.next = new_node;
            tail = tail.next;
        }
        size++;
    }

    //Removes and returns item form the front of the deque
    public Item removeFirst(){
        if (isEmpty()){throw new NoSuchElementException("Cannot remove item from empty deque");}

        Item data = head.item;
        head = head.next;
        if (head == null) {tail = null;}
        else              {head.prev = null;}
        size--;
        return data;
    }

    //Removes and returns item from the end of the deque
    public Item removeLast(){

        if (isEmpty()){throw new NoSuchElementException("Cannot remove item from empty deque");}

        Item data = tail.item;
        tail = tail.prev;
        if (tail == null) {head = null;}
        else              {tail.next = null;}
        size--;
        return data;
    }
}
