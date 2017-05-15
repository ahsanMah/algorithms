import edu.princeton.cs.algs4.StdIn;

/**
 * Created by smaug on 1/12/17.
 */
public class Permutation {

    public static void main (String[] args){
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randQ = new RandomizedQueue<String>();

        while(!StdIn.isEmpty()){
            randQ.enqueue(StdIn.readString());
        }

        //System.out.format("Size: %d\n", randQ.size());

        for (int i=0;i<k;i++)
            System.out.println(randQ.dequeue());

    }

}
