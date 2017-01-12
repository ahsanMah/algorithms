import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by smaug on 1/12/17.
 */
public class TestRandQ {

    RandomizedQueue<Integer> test;

    public TestRandQ(){test = new RandomizedQueue<Integer>();}

    public void testAdd(){

        Integer MAX = 100;

        for (Integer i = 0; i < MAX ;i++){
            test.enqueue(i);
        }

        for (Integer i = 0; i < MAX/2 ;i++){
            System.out.format("%d: %d\n",i,test.dequeue());
        }


        System.out.format("Size:%d , Empty:%b \n", test.size(), test.isEmpty() );
//        for (Integer i = 0; i<5; i++)
//            System.out.println();
    }

    public static void main(String args[]){
        Stopwatch time = new Stopwatch();
        TestRandQ randQ = new TestRandQ();
        randQ.testAdd();
        System.out.println("-----------------");
        System.out.format("Time elapsed %.3fs \n", time.elapsedTime());
    }
}
