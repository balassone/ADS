package Prova160222;
import java.util.Arrays;
import java.util.Scanner;                                                                             
                                                                                                      
public class prova2 {                                                                       
    public static void main(String[] args) {                                                          
        Scanner scanner = new Scanner(System.in);                                                     
                                                                                                      
        int T = scanner.nextInt(); // Numero di casi di test                                          
                                                                                                      
        for (int t = 0; t < T; t++) {                                                                 
            int M = scanner.nextInt(); // Numero di righe
            int N = scanner.nextInt(); // Numero di colonne                                           
                                                                                                      
            int[][] matrix = new int[M][N];
                                                                                                      
            // Lettura della matrice
            for (int i = 0; i < M; i++) {                                                             
                for (int j = 0; j < N; j++) {                                                         
                    matrix[i][j] = scanner.nextInt();
                }                                                                                     
            }
                                                                                                      
            int maxFreeSubmatrixSize = findMaxFreeSubmatrix(matrix);                                  
            System.out.println(maxFreeSubmatrixSize);                                                 
        }                                                                                             
    }
                                                                                                      
    private static int findMaxFreeSubmatrix(int[][] matrix) {                                         
        int M = matrix.length;
        int N = matrix[0].length;
                                                                                                      
        // Creazione di una matrice ausiliaria per memorizzare la lunghezza della sottomatrice libera massima
        int[][] dp = new int[M][N];                                                                   
                                                                                                      
        // Inizializzazione della prima riga e prima colonna della matrice dp                         
        for (int i = 0; i < M; i++) {                                                                 
            dp[i][0] = matrix[i][0];                                                                  
        }
        for (int j = 0; j < N; j++) {
            dp[0][j] = matrix[0][j];
        }
                                                                                                      
        // Calcolo della matrice dp
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {                                                              
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;  
                } else {                                                                              
                    dp[i][j] = 0;                                                                     
                }                                                                                     
            }
        }
                                                                                                      
        // Trovare il massimo valore nella matrice dp
        int maxFreeSubmatrixSize = 0;                    
        int l=0; 
        int value = Integer.MIN_VALUE;                                            
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {                                                             
                maxFreeSubmatrixSize = Math.max(maxFreeSubmatrixSize, dp[i][j]); 
                if(value<maxFreeSubmatrixSize){
                    l=Math.min(i, j);
                    value=maxFreeSubmatrixSize;
                }
            }
        }

        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
                                  
        System.out.println(l);
        return maxFreeSubmatrixSize*l;                                                                  
    }
}