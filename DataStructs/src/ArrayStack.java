/**
 * Created by smaug on 1/2/17.
 */
public class ArrayStack {

    String[] stack = new String [1];
    int N = 0;
    //public ArrayStack();

    private void resize(int length){
        String[] s = new String[length];
        for (int i = 0; i < N; i++) {
            s[i] = stack[i];
        }
        stack = s;
        //System.out.println("Resized!");
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public String pop(){
        String data = stack[N-1];
        stack[N-1] = null;
        N--;
        if (N > 0 && N <= stack.length/4){resize(stack.length/2);}
        return data;
    }

    public void push(String data){
        if (N == stack.length)
            resize(stack.length*2);
        stack[N] = data;
        N++;
    }

}
