// 1. Divido array in due parti
// 2. Divide solo uno dei due: ci dice pivot e numero di divisioni
// 3. Divisione costa quanti elementi ci sono nell'array
// 4. Costo minimo per dividere l'array quante volte indicato

#include <stdio.h>

/*

passo=1 ho il numero di elementi, 
p=2 ho il numero di elementi + n-A[p] a dx e A[p] a sx

//DP[i]=min{DP[i-1]+ci}

[n]
[n]
[n]


*/

int min(int a, int b){
    return a<b?a:b;
}

int alg(int start, int finish, int* pivots, int p, int dp[][256]){
    int pivotsavailable[p];
    int dimP=0;
    for(int i=0; i<p; i++){
        if (pivots[i]>start && pivots[i]<finish){
            pivotsavailable[dimP++]=pivots[i];
        }
    }
    if(dimP==0) return 0;
    if(dp[start][finish]!=-1) return dp[start][finish];
    int mini = (finish-start)+alg(start,pivotsavailable[0],pivots,p,dp)+alg(pivotsavailable[0],finish,pivots,p,dp);
    for(int i=1; i<dimP; i++){
        mini = min(mini,(finish-start)+alg(start,pivotsavailable[i],pivots,p,dp)+alg(pivotsavailable[i],finish,pivots,p,dp));
    }
    dp[start][finish]=mini;
    return dp[start][finish];
}


int main(){
    int n, p;
    scanf("%d",&n);
    scanf("%d",&p);
    int pivots[p];
    int dp[n+1][n+1];
    for(int i=0; i<p; i++) scanf("%d",&pivots[i]);
    for(int i=0; i<n+1; i++){
        for(int j=0; j<n+1; j++){
            dp[i][j]=-1;
        }
    }
    int res = alg(0,n,pivots,p,dp);
    printf("%d\n",res);
}


