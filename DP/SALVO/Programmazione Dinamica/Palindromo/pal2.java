package Palindromo;
import java.util.Scanner;

public class pal2 {
    
   
    static int longestPalindromicSubseq(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        return longestPalindromicSubseqUtil(str, 0, n - 1, dp);
    }

    // Funzione di supporto per il calcolo della lunghezza del palindromo più lungo (problema di tipo LIS)
    static int longestPalindromicSubseqUtil(String str, int start, int end, int[][] dp) {
        if (start > end) return 0;  //se si sono incrociati tra loro, torno 0
        if (start == end) return 1; //se invece sono alla stessa posizione, torno 1

        if (dp[start][end] != 0) return dp[start][end]; //se è preseentegià, torno il valore già presente

        if (str.charAt(start) == str.charAt(end)) {  //se due lettere a inizio e fine sono uguali, salvo 2 + ricorsione andandi avanti di 1 sia avanti che dietro
            dp[start][end] = 2 + longestPalindromicSubseqUtil(str, start + 1, end - 1, dp);
        } else { //sennò salvo il massimo andando avanti o dietro
            dp[start][end] = Math.max(longestPalindromicSubseqUtil(str, start + 1, end, dp), longestPalindromicSubseqUtil(str, start, end - 1, dp));
        }

        return dp[start][end]; //torno il valore degli indici
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine(); // Consumes newline character after integer input

        while (T-- > 0) {                                                                                                                                                                                                                
            String str = scanner.nextLine();                                                                                                                                                                                             
            int result = longestPalindromicSubseq(str);                                                                                                                                                                                  
            System.out.println(result);                                                                                                                                                                                                  
        }
                                                                                                                                                                                                                                         
        scanner.close();                                                                                                                                                                                                                 
    }
}