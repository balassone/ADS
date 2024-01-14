package TracciaFebbraio;

import java.util.ArrayList;
import java.util.Arrays;

public class suddivisioni {

    //complessitò #numero sottoproblemi = n*n tempo di rosoluzione=n, circa O(n^3)

    public static int [][] dp;


    public static int foundMinDivide(int [] piv, int start, int end){

        ArrayList<Integer> pivots = new ArrayList<>(); //creo ogni volta i pivot che mi possono servire

        for (int i : piv) {
            if(i>start && i<end){  //devono essere maggiore di start e minori di end
                pivots.add(i);
            }
        }

        if(pivots.size()==0){ //se non ne ho, torno 0
            return 0;
        }

        if(dp[start][end]!=-1){ //memoization
            return dp[start][end];
        }

        if(start==end){ //sennò torno 0 se sono su diag principale
            return 0;
        }

        
        int value=Integer.MAX_VALUE; //inizializzo value

        for(int i=0; i<pivots.size(); i++){
            value = Math.min(value, foundMinDivide(piv, start, pivots.get(i)) + foundMinDivide(piv, pivots.get(i), end) + (end-start)); //per tutti i pivots possibili, parentesizzazione!
        }

        dp[start][end]=value;
        //salvo e torno il minimo
        return dp[start][end];


    }




    public static void main(String[] args) {
        
        int [] piv = {25, 50, 75}; //insieme di pivot 

        dp = new int[101][101]; //genero la matrice di supporto dp

        for (int [] i : dp) {
            Arrays.fill(i, -1); //la riempio di -1
        }

        
        int v1 = foundMinDivide(piv, 0, 100); //evoco
        System.out.println(v1); //stampo valore
        
        
        

        

    }
    
}
