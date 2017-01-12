import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by smaug on 1/12/17.
 */
public class RandomizedQueue<Item> implements Iterable<Item>{

    private class randIterator implements Iterator<Item> {
        int curr = 0;
        Item[] iterQ = (Item[]) new Object[queue.length];

        public randIterator(){
            int idx = 0;
            for (int i = 0; i < queue.length; i++){
                if (queue[i] != null){
                    iterQ[idx++] = queue[i];
                }
            }

        }

        public Item next(){return queue[0];}
        public boolean hasNext(){return curr != iterQ.length;}
    }

    private Item[] queue;
    private int tail;
    private int size;
    private final boolean DEBUG = true;

    public RandomizedQueue(){
        queue = (Item[]) new Object[5];
        tail  = 0;
        size = 0;
    }

    public boolean isEmpty(){ return size == 0;}

    public int size(){return size;}

    //Resizes array to given length
    private void resize(int length){
        Item[] temp = (Item[]) new Object[length];
        int idx = 0;
        for (int i = 0; i < queue.length; i++){
            if (queue[i] != null){
                temp[idx++] = queue[i];
            }
        }
        queue = temp;
        tail = idx;

        if (DEBUG) System.out.format("Size:%d Length: %d\n",size, length);
    }

    public void enqueue(Item item){
        queue[tail] = item;
        tail++;
        size++;

        if (tail == queue.length)
            resize(queue.length*2);

    }

    public Item dequeue(){
        Item data = null;
        int idx = 0;
        while (data == null){
            idx = StdRandom.uniform(tail+1);
            data = queue[idx];
        }
        queue[idx] = null;
        size--;

        if(size < queue.length/4)
            resize(queue.length/2);

        return data;
    }

    public Item sample(){
        Item data = null;
        int idx = 0;
        while (data == null){
            idx = StdRandom.uniform(tail+1);
            data = queue[idx];
        }
        return data;
    }

    public Iterator<Item> iterator(){return new randIterator();}
}
