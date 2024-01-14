

import java.util.Scanner;

public class prova {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Numero di casi di test

        for (int t = 0; t < T; t++) {
            int B = scanner.nextInt(); // Budget
            int C = scanner.nextInt(); // Numero di classi di prodotti

            int[][] prices = new int[C][]; // Array per memorizzare i prezzi dei prodotti per ogni classe

            for (int i = 0; i < C; i++) {
                int M = scanner.nextInt(); // Numero di prodotti per la classe
                prices[i] = new int[M];

                for (int j = 0; j < M; j++) {
                    prices[i][j] = scanner.nextInt(); // Prezzi dei prodotti per la classe
                }
            }

            int result = massimoDenaro(B, prices, 0, 0);

            if (result == -1) {
                System.out.println("denaro insufficiente");
            } else {
                System.out.println(result);
            }
        }

        scanner.close();
    }

    private static int massimoDenaro(int budget, int[][] prices, int currentClass, int currentBudget) {
        if (currentClass == prices.length) {
            // Arrivati all'ultima classe, restituisci il budget corrente
            return currentBudget;
        }

        int maxDenaro = -1;

        // Prova ad acquistare ogni prodotto della classe corrente e passa alla classe successiva
        for (int i = 0; i < prices[currentClass].length; i++) {
            if (currentBudget + prices[currentClass][i] <= budget) {
                int denaroRimanente = massimoDenaro(budget, prices, currentClass + 1, currentBudget + prices[currentClass][i]);
                if (denaroRimanente != -1) {
                    // Se la classe successiva restituisce un valore valido, aggiorna il massimodenaro
                    maxDenaro = Math.max(maxDenaro, denaroRimanente);
                }
            }
        }

        return maxDenaro;
    }
}
