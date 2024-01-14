import java.util.*;
import java.io.*;

public class ProvaFinale3 {
    private static File input = new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Programmazione Dinamica\\Alg Dividi et Impera BottomUp DP\\src\\testFile.txt");

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(input);

        int n, p;

        while (true) {

            n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            p = scanner.nextInt();

            int[] C = new int[p + 2];

            C[0] = 0;
            for (int i = 1; i <= p; i++) {
                C[i] = scanner.nextInt();
            }
            C[p + 1] = n;

            int sol = trovaMin(p + 1, C);

            System.out.println(sol);
        }

        scanner.close();
    }

    public static int trovaMin(int cuts, int[] C) {
        int[][] DP = new int[cuts + 1][cuts + 1];

        for (int len = 2; len <= cuts; len++) // segmenti di lunghezza 2 in poi
        {
            for (int i = 0; i <= (cuts - len); i++) // tutti gli inizi possibili i
            {
                int j = i + len;
                DP[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) // i possibili tagli k
                {
                    DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k][j] + (C[j] - C[i]));
                }
            }
        }

        return DP[0][cuts];
    }

}

// Analisi complessità:
// Ci sono tre cicli annidati: il primo per la lunghezza dei segmenti,
// il secondo per gli inizi possibili i, e il terzo per i possibili tagli k.
// La complessità di questi cicli annidati è O(fine^3) => O(p^3)
