package PreAppello2022;

import java.util.Arrays;
import java.util.Scanner;

public class prova2 {                                                                                                                                                                                                  
                                                                                                                                                                                                                                         
    static int maxCommunication(int[] x, int[] y, int n) {                                                                                                                                                                               
        int[] dp = new int[n + 1];                                                                                                                                                                                                       
        Arrays.fill(dp, 0);                                                                                                                                                                                                              
                                                                                                                                                                                                                                         
        for (int i = 1; i <= n; i++) {                                                                                                                                                                                                   
            for (int j = 1; j < i; j++) {                                                                                                                                                                                                
                if ((x[j - 1] < x[i - 1] && y[j - 1] > y[i - 1]) ||                                                                                                                                                                      
                    (x[j - 1] > x[i - 1] && y[j - 1] < y[i - 1])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }                                                                                                                                                                                                                        
            }
        }                                                                                                                                                                                                                                
                                                                                                                                                                                                                                         
        int max = 0;                                                                                                                                                                                                                     
        for (int i = 1; i <= n; i++) {                                                                                                                                                                                                   
            max = Math.max(max, dp[i]);
        }                                                                                                                                                                                                                                
        return max;                                                                                                                                                                                                                      
    }                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                         
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();                                                                                                                                                                                                       
                                                                                                                                                                                                                                         
        while (T-- > 0) {                                                                                                                                                                                                                
            int n = scanner.nextInt();                                                                                                                                                                                                   
            int[] x = new int[n];                                                                                                                                                                                                        
            int[] y = new int[n];
                                                                                                                                                                                                                                         
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }                                                                                                                                                                                                                            
                                                                                                                                                                                                                                         
            for (int i = 0; i < n; i++) {                                                                                                                                                                                                
                y[i] = scanner.nextInt();
            }                                                                                                                                                                                                                            
                                                                                                                                                                                                                                         
            int result = maxCommunication(x, y, n);
            System.out.println(result);
        }
    }
}