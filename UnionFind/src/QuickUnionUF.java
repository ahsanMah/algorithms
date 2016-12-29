/**
 * Created by smaug on 12/25/16.
 */
public class QuickUnionUF {

    private int[] id,sz;

    public QuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i<N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    //CHECKS WHETEHR TWO NODES ARE CONNECTED
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    //RETURNS ROOT NODE OF ANY GIVEN ENTRY
    public int old_root(int p) {

        if (id[p] == p)
            return p;
        return old_root(id[p]);
    }

    public void quickUnion(int p, int q){
        int proot = old_root(p);
        int qroot = old_root(q);

        id[proot] = qroot;
    }

    //FLLATTENS ALONG THE WAY
    public int root(int p){
        if (id[p] == p)
            return p;

        id[p] = id[id[p]];
        return root(id[p]);
    }

    //IF RIGHT ROOT SZ <= LEFT ROOT SZ, LEFT BECOMES PARENT
    public void weightedUnion(int p, int q){
        int proot = root(p);
        int qroot = root(q);

        if (sz[qroot] <= sz[proot]){
            id[qroot] = proot;
            sz[proot] += sz[qroot];
        }
        else{
            id[proot] = qroot;
            sz[qroot] = sz[proot];
        }

    }

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
