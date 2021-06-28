import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        // Only 4 attacking positions 
        // i-1,j-2
        // i-2,j-1
        // i-2,j+1
        // i-1,j+2
        
        // Other 4 can not attack as knight is not placed as they are yet to be visited
        // i+1,j+2
        // i+2,j+1
        // i+2,j-1
        // i+1,j-2
       
        if(i-1 >= 0 && j-2 >= 0 && chess[i-1][j-2] == true){
            return false;
        }
        if(i-2 >= 0 && j-1 >= 0 && chess[i-2][j-1] == true){
            return false;
        }
        if(i-2 >= 0 && j+1 < chess[0].length && chess[i-2][j+1] == true){
            return false;
        }
        if(i-1 >= 0 && j+2 < chess[0].length && chess[i-1][j+2] == true){
            return false;
        }
        
        return true;
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}