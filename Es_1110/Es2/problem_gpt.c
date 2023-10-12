#include <stdio.h>

int findBallPosition(int depth, int n) {
    int position = 1;  // Iniziamo dalla radice

    for (int d = 1; d < depth; d++) {
        if (n % 2 == 1) {
            // Se il nodo è dispari, vai a sinistra se il bit meno significativo di n è 1
            position = position * 2;
            n = (n + 1) / 2;
        } else {
            // Altrimenti vai a destra se il bit meno significativo di n è 0
            position = position * 2 + 1;
            n = n / 2;
        }
    }

    return position;
}

int main() {
    FILE* file = fopen("problem.txt","r");
    int T;  // Numero di casi di test
    fscanf(file,"%d", &T);

    while (T--) {
        int depth, n;
        fscanf(file,"%d %d", &depth, &n);

        int finalPosition = findBallPosition(depth, n);
        printf("%d\n", finalPosition);
    }

    return 0;
}
