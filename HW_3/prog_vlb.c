#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int min(int a, int b) { return (a < b)? a : b; }

int findMinDiff(int monete[], int n, int somma) {
    bool dp[n+1][somma+1];
    for (int i=0; i<=n; i++)
        dp[i][0] = true;
    for (int i=1; i<=somma; i++)
        dp[0][i] = false;
    for (int i=1; i<=n; i++) {
        for (int j=1; j<=somma; j++) {
            dp[i][j] = dp[i-1][j];
            if (monete[i-1] <= j)
                dp[i][j] |= dp[i-1][j-monete[i-1]];
        }
    }
    int diff = -1;
    for (int j=somma/2; j>=0; j--) {
        if (dp[n][j] == true) {
            diff = somma-2*j;
            break;
        }
    }
    return diff;
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
        printf("%d\n", findMinDiff(monete, n, somma));
    }
    return 0;
}
