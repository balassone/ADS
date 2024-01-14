package LCS;

import java.util.Arrays;

public class common {

    //complessita' O(m*n) cioe' prodotto delle cardinalita' delle due stringhe 
    


    public static int [][] dp;


    public static int LCS(String s1, String s2, int i, int j){

        if(i==s1.length() || j==s2.length()){ //se sono arrivato oltre le due stringhe torno 0
            return 0;
        }

        if(dp[i][j]!=-1){ //se invece la posizione sembra gia' essere esplorata, torno il valore
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 1+LCS(s1, s2, i+1, j+1); //se sono uguali, memorizzo 1 + chiamata LCS con incremento di entrambi
        } 
    
        
        return dp[i][j] = Math.max(LCS(s1, s2, i+1, j), LCS(s1, s2, i, j+1)); //senno salvo il massimo tra le due chiamate incrementando uno solo dei due
        

    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB"; //le due stringhe da valutare

        dp = new int[s1.length()][s2.length()]; //creazione della matrice con le due lunghezze

        for (int [] row : dp) {
            Arrays.fill(row, -1); //la fillo di -1
        }

    
        System.out.println(LCS(s1, s2, 0, 0)); //chiamo la funzione 

       
    }
}
