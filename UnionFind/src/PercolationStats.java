/**
 * Created by smaug on 12/28/16.
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double results[];
    private double grid_size;
    private int size, num_trials;

    public PercolationStats(int n, int trials){
        if (n<= 0 || trials <= 0){
            throw new IllegalArgumentException("Grid size or trial count cannot be below 1");
        }
        size = n;
        grid_size = n*n;
        results = new double[trials];
        num_trials = trials;
        runTrials();
    }

    private void runTrials(){
        for (int i = 0; i < num_trials; i++){
            results[i]=singleTrial();
        }
    }

    /*
    *Performs one trial on an nxn grid
    *Returns the percolation threshold of the system
    */
    private double singleTrial(){
        int x,y;

        Percolation test = new Percolation(size);

        while(!test.percolates()) {
            x = StdRandom.uniform(1,size+1);
            y = StdRandom.uniform(1,size+1);
            test.open(x,y);
        }

        return test.numberOfOpenSites()/grid_size;
    }

    private double stderr(){ return stddev()/Math.sqrt(num_trials); }
    public double mean(){ return StdStats.mean(results); }
    public double stddev(){ return StdStats.stddev(results); }
    public double confidenceLo(){ return mean()-1.96*stderr(); }
    public double confidenceHi(){ return mean()+1.96*stderr(); }

    public static void main (String[] args){
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats test = new PercolationStats(N,T);
        System.out.format("mean                     = %f\n", test.mean());
        System.out.format("stddev                   = %f\n", test.stddev());
        System.out.format("95%% confidence interval  = %f, %f\n", test.confidenceLo(), test.confidenceHi());
    }
}
