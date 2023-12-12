#include <stdio.h>
#include <stdlib.h>

int max(int a, int b) { return (a > b)? a : b; }

int main() {
    int t;
    FILE* file = fopen("input.txt","r");
    fscanf(file, "%d", &t);
    while(t--) {
        int n;
        fscanf(file, "%d", &n);
        int coins[n], sum = 0;
        for(int i=0; i<n; i++) {
            fscanf(file, "%d", &coins[i]);
            sum += coins[i];
        }
        // Somma contiene il valore totale del bottino
        int dp[sum+1]; //dp è un array di sum+1 caselle, lo inizializzo a zero:
        for(int i=0; i<=sum; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=sum; j>=coins[i]; j--) {
                if(dp[j-coins[i]]) {
                    dp[j] = max(dp[j], dp[j-coins[i]] + coins[i]);
                }
            }
        }
        int diff = sum;
        for(int i=sum/2; i>=0; i--) {
            if(dp[i]) {
                diff = sum - 2*i;
                break;
            }
        }
        printf("%d\n", diff);
    }
    return 0;
}
