/**
 * Created by smaug on 1/2/17.
 */

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        Stopwatch time = new Stopwatch();
        Deque<String> dstack = new Deque<String>();


//        dstack.addFirst(null);
        dstack.addFirst("1");
        dstack.addFirst("2");
//        dstack.removeLast();
        //dstack.removeFirst();
//        dstack.addLast("Hello!");
//        dstack.removeFirst();
        dstack.removeLast();
        dstack.removeLast();
  //      dstack.removeLast();
//        dstack.addFirst("World..?");
        dstack.addLast("Who am I?");
//        dstack.addLast("Im last");

        System.out.format("Size:%d, Empty:%b \n", dstack.size(), dstack.isEmpty());
        Iterator<String> iter = dstack.iterator();

        for (String item:dstack) {
            System.out.println(item);
        }
        System.out.format("Time elapsed %.3fms \n", time.elapsedTime());
    }
}
