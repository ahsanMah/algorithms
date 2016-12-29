/**
 * Created by smaug on 12/24/16.
 */
public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N){
        id = new int[N];
        for (int i = 0; i<N; i++){
            id[i]=i;
        }
    }

    //CHECKS WHETEHR TWO NODES ARE CONNECTED
    public boolean old_connected(int p, int q){
        return id[p] == id[q];

    }

    //COMBINES TWO COMPONENTS
    public void union(int p, int q){
        int old_id = id[p];
        int new_id = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == old_id)
                id[i] = new_id;
        }
    }

    //TODO: Make fancier string output
    public String toString(){
        String output = "";
        String header = "";

        for (int i=0; i< id.length; i++){
            header += String.valueOf(i) + " ";
            output += String.valueOf(id[i]) + " ";
        }

        return header + "\n-------------------\n" + output;
    }

}
