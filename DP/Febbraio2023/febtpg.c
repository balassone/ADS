/*

Si consideri un algoritmo di tipo Divide et Impera D che opera su un array di interi con 1 ≤ n ≤ 1000 elementi. Al primo passo l’algoritmo divide l’array in due parti; successivamente continua a dividere solo uno dei due sotto-array. Il numero di divisioni da fare e l’insieme dei pivot da usare (ossia i punti in cui si dovrà suddividere l’array) sono dati in ingresso. Ad ogni operazione di suddivisione fatta da Alg è associato un costo, che è pari al numero di elementi dell’array (o del sotto-array) da suddividere. È facile notare che selezioni diverse nell'ordine dei pivot (ossia dove suddividere prima) possono portare a costi diversi. Ad esempio, si consideri un array di 100 elementi, e siano i possibili pivot 25, 50 e 75. Ci sono diverse scelte. L’algoritmo D può suddividere prima a 25, poi a 50, poi a 75. Questo porta ad un costo di 100 elementi + 75 elementi + 50 elementi = 225 perché il primo array era di 100 elementi, il secondo, risultante dalla prima suddivisione, di 75 e l'ultima, risultante dalla seconda suddivisione, di 50. Un’altra scelta potrebbe essere scegliere come pivot 50, poi a 25, poi a 75. Questo porterebbe a un costo di 100 + 50 + 50 = 200, che è migliore. Si progetti un algoritmo per determinare il costo minimo che D impiega per suddividere l’array il numero di volte indicato.
INPUT
L'input è costituito da diversi test. La prima riga di ogni test case conterrà un numero intero positivo n che rappresenta la lunghezza dell’array. Si assuma 1 ≤ n ≤ 1000. La riga successiva conterrà il numero intero p (n < 50) di pivot da usare.
La riga successiva è composta da p numeri interi positivi ci (0 < ci < n) che rappresentano i pivot, dati in ordine strettamente crescente.
Un caso con n = 0 rappresenta la fine dell'input. OUTPUT
Bisogna stampare il costo della soluzione ottima, cioè il costo totale minimo delle suddivisioni.
Sample Input
30
3 2
20 25 
10
4
4 5 7 8
100
3
25 50 75
0
Sample Output
60
22

200

risolvere con programmazione dinamica
*/

#include <stdio.h>
#include <stdlib.h>

int min(int a, int b){
    if(a<b) return a;
    else return b;
}

int solve(int n, int p, int a[], int dp[][100]){
    if (p<=0) return 0;
    if(p==1) return n;
    if(dp[n][p]!=-1) return dp[n][p];
    int minimo = 1000000;
    for(int i=0; i<p; i++){
        int costo = n + solve(a[i],i+1,a,dp) + solve(n-a[i],p-i-1,a+i+1,dp);
        minimo = min(minimo,costo);
    }
    dp[n][p] = minimo;
    return minimo;
}

//alloca dp senza malloc

int main(){
    int n, p;
    while(1){
        scanf("%d",&n);
        if(n!=0){
            scanf("%d",&p);
            int a[p];
            for(int i=0; i<p; i++){
                scanf("%d",&a[i]);
            }

            int dp[n+1][p+1];
            
            for(int i=0; i<=n; i++){
                
                for(int j=0; j<=p; j++){
                    dp[i][j] = -1;
                }
            }
            printf("%d\n",solve(n,p,a,dp));
        } else {
            break;
        }
    }
}