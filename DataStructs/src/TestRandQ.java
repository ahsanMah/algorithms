import edu.princeton.cs.algs4.Stopwatch;

import java.util.NoSuchElementException;

/**
 * Created by smaug on 1/12/17.
 */
public class TestRandQ {

    RandomizedQueue<Integer> test;
    Integer MAX = 10;

    public TestRandQ(){test = new RandomizedQueue<Integer>();}

    public void testAdd(){

        for (Integer i = 0; i < MAX ;i++){
            test.enqueue(i);
        }
        testIter();
        testSize();
    }

    public void testRemove(){

        try{test.dequeue();}
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }



        for (Integer i = 0; i < MAX/2 ;i++){
            System.out.format("%d: %d\n",i,test.dequeue());
        }
        testIter();
        testSize();
    }

    //Performs nested iterations to ensure both iterators work independently
    private void testIter(){
        for (Integer data: test) {
            System.out.format("%d: ", data);
            for (Integer item: test)
                System.out.print(item);
            System.out.println();
        }
    }

    //Returns size
    private void testSize(){
        System.out.format("Size:%d , Empty:%b \n", test.size(), test.isEmpty() );
    }

    public static void main(String args[]){
        Stopwatch time = new Stopwatch();
        TestRandQ randQ = new TestRandQ();
        randQ.testAdd();
        randQ.testRemove();
        System.out.println("-----------------");
        System.out.format("Time elapsed %.3fs \n", time.elapsedTime());
    }
}
