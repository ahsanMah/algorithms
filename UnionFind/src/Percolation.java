/**
 * Created by smaug on 12/26/16.
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.*;

public class Percolation {

    private WeightedQuickUnionUF cells, cells_nb;
    private int row_size, size, open_counter;
    private boolean open_sites[];
    private int TOP, BOTTOM;

    //create virtual top and bottom sites
    public Percolation(int N){
        if (N <= 0)
            throw new IllegalArgumentException();
        cells = new WeightedQuickUnionUF((N*N)+2); //+2 for virtual top (idx = 0) and bottom (idx = N+1)
        cells_nb = new WeightedQuickUnionUF(N*N+1); //cells without virtual bottom
        open_sites = new boolean[N*N+2];
        open_counter = 0;
        row_size = N;
        size = N*N;
        TOP = 0;
        BOTTOM= (N*N)+1;
    }

    private int convertTo1D(int row, int col){
        return (row-1)*row_size + col;
    }

    //validates an idx position
    private boolean validate(int idx){
        if (idx < 1 || idx > size)
            throw new IndexOutOfBoundsException();
        return true;
    }

    /*
    * Returns an array of neighbours of a point on the N*N grid in order shown below
    * (row,col) -> [top,bottom,left,right]
    * If neighbour does not exist, idx = -1
    * */
    private int[] calculateNeighbours(int row, int col){
        int [] neighbours = new int[4];
        int idx;
        //todo: REPLACE CHECKS WITH CALL TO VALIDATE
        //top
        neighbours[0] = (row-1 < 1)? -1:convertTo1D(row-1,col);

        //bottom
        neighbours[1] = (row+1 > row_size)? -1:convertTo1D(row+1,col);

        //left
        neighbours[2] = (col-1 < 1)? -1:convertTo1D(row,col-1);

        //right
        neighbours[3] = (col+1 > row_size)? -1:convertTo1D(row,col+1);

        return neighbours;
    }

    public void open(int row, int col){
        int idx = convertTo1D(row,col);

        validate(idx);

        if (open_sites[idx])
            return;

        open_sites[idx] = true;
        open_counter++;

        // Make every element in first row point to virtual root
        if (idx <= row_size) {
            //System.out.println("Connecting to TOP");
            cells.union(TOP, idx);
            cells_nb.union(TOP, idx);
        }

        if (idx>row_size*(row_size-1)) {
            //System.out.println("Connecting to BOTTOM");
            cells.union(idx, BOTTOM);
        }

        //Calculating neighbour indices
        int[] neighbours = calculateNeighbours(row,col);

        for (int n_idx:neighbours){
            if (n_idx != -1 && open_sites[n_idx]) {
                cells.union(idx, n_idx);
                cells_nb.union(idx, n_idx);
            }
        }
    }

    public boolean isOpen(int row, int col){
        int idx = convertTo1D(row,col);
        validate(idx);
        return open_sites[idx];
    }

    //Returns true cell connected to virtual top
    public boolean isFull(int row, int col){
        int idx = convertTo1D(row,col);
        validate(idx);
        return cells_nb.connected(TOP,idx);
    }

    public int numberOfOpenSites(){
        return open_counter;
    }

    public boolean percolates(){
        return cells.connected(TOP,BOTTOM);
    }

    public static void main(String args[]){

        Percolation test = new Percolation(1);
        System.out.format("Percolates: %b\n", test.percolates());
        System.out.format("Percolates: %b\n", test.percolates());
        test.open(1,1);
        System.out.format("Open(1,1) : %b\n", test.isOpen(1,1));
        System.out.format("Full(1,1) : %b\n", test.isFull(1,1));
        System.out.format("Testing connection (1,1) w/ TOP : %b\n", test.cells.connected(0,1));
        System.out.format("Percolates: %b\n", test.percolates());

//        Percolation test = new Percolation(3);
//
//        System.out.println("Mini test cases");
//        System.out.println("-------");
//
//        System.out.format("Converting (3,2): %d\n" ,test.convertTo1D(2,5));
//
//        System.out.println();
//        System.out.println("-------");
//        System.out.println("Opening (1,2)");
//        test.open(1,2);
//        System.out.println("Opening (2,2)");
//        test.open(2,2);
//
//        System.out.println("Opening (3,3)");
//        test.open(3,3);
//
//        System.out.println("Opening (2,3)");
//        test.open(2,3);
//
//        System.out.println("Opening (3,1)");
//        test.open(3,1);
//
//
//        System.out.println();
//        System.out.println("-------");
//        System.out.format("Open(1,1) : %b\n", test.isOpen(1,1));
//        System.out.format("Open(1,2) : %b\n", test.isOpen(2,3));
//        System.out.format("Full(2,2) : %b\n", test.isFull(2,2));
//        System.out.format("Full(3,1) : %b\n", test.isFull(3,1));
//
//        System.out.println();
//        System.out.println("-------");
//        System.out.format("Testing connection (1,2) w/ (2,2) : %b\n", test.cells.connected(0,2));
//        System.out.format("Testing connection (2,2) w/ (2,1) : %b\n", test.cells.connected(4,5));
//        System.out.format("Testing connection (2,2) w/ (2,3) : %b\n", test.cells.connected(5,6));
//
//        System.out.println();
//        System.out.println("-------");
//        System.out.format("Percolates: %b\n", test.percolates());
    }

}
