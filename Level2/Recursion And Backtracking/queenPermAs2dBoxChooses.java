import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        // qpsf   - queen placed so far
        // tq     - total queens
        // row    - curr row
        // col    - curr col
        // asf    - placement so far
        // queens - queen placed or not
        
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();
            }
            return ;
        }
        
        int nr, nc;
        String sep;
        if(col == tq-1){
            nr = row+1;
            nc = 0;
            sep = "\n";
        } else {
            nr = row;
            nc = col+1;
            sep = "\t";
        }
        
        for(int i = 0 ; i < queens.length; i++){
            if(queens[i] == false){
                queens[i] = true;
                queensPermutations(qpsf+1, tq, nr, nc, asf+"q"+(i+1)+sep, queens);
                queens[i] = false;
            }
        }
        queensPermutations(qpsf, tq, nr, nc, asf+"-"+sep, queens);
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}