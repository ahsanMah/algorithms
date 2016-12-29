/**
 * Created by smaug on 12/25/16.
 */
import edu.princeton.cs.algs4.StdRandom;

public class Main {

    public static void main(String[] args){

        QuickUnionUF uf =  new QuickUnionUF(10);

        uf.weightedUnion(4,3);
        System.out.println(uf.toString());
        System.out.println();
        uf.weightedUnion(3,8);
        uf.weightedUnion(6,5);
        uf.weightedUnion(9,4);
        uf.weightedUnion(2,1);
        uf.weightedUnion(5,0);
        uf.weightedUnion(7,2);
        uf.weightedUnion(6,1);
        uf.weightedUnion(7,3);
        System.out.println(uf.toString());

    }
}
