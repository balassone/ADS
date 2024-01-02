#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int min(int a, int b) {
    return (a<b)? a : b;
}

int findMinDiff(int monete[], int n, int somma) {

    bool dp[n+1][somma+1];

    for (int i=0; i<=n; i++){
        dp[i][0] = true; // Somma nulla utilizzando 0 o più monete
    }

    for (int i=1; i<=somma; i++){
        dp[0][i] = false; // Non posso ottenere una somma > 0 senza monete
    }
    for (int i=1; i<=n; i++) { // Itero sulle monete
        for (int j=1; j<=somma; j++) { // Itero sulle somme
            dp[i][j] = dp[i-1][j]; // Se non posso ottenere la somma j con le prime i monete, non posso ottenerla nemmeno con le prime i-1 monete
            if (monete[i-1] <= j) // Se la moneta i-esima è minore della somma j, posso ottenere la somma j con le prime i monete se posso ottenerla con le prime i-1 monete o con le prime i-1 monete e la moneta i-esima
                dp[i][j] |= dp[i-1][j-monete[i-1]]; 
        }
    }
    int diff = -1;
    for (int j=somma/2; j>=0; j--) { // Cerco la somma più grande <= somma/2 che posso ottenere
        if (dp[n][j] == true) {
            diff = somma-2*j;
            break;
        }
    }
    return diff; // Se diff == -1 non ho trovato nessuna somma <= somma/2 che posso ottenere
}

int main() {
    FILE* file = fopen("input.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int n;
        fscanf(file,"%d",&n);
        int monete[n];
        int somma=0;
        for(int i=0; i<n; i++){
            fscanf(file,"%d",&monete[i]);
            somma += monete[i];
        }
        int diff = findMinDiff(monete,n,somma);
        if(diff != -1){
            printf("%d\n",diff);
        } else {
            printf("ERR\n");
        }
    }
    return 0;
}
