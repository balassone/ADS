#include <stdio.h>
#include <stdlib.h>
#define MAX 100

int max(int a, int b){
    return a>b?a:b;
}

typedef char String[256];

int LCS(String A, String B, int m, int n, int DP[][MAX]){
    if(m==0 || n==0) return 0;
    if(A[m-1]==B[n-1]) return DP[m][n] = 1+LCS(A,B,m-1,n-1,DP);
    if(DP[m][n]!=-1) return DP[m][n];
    return DP[m][n] = max(LCS(A,B,m-1,n,DP),LCS(A,B,m,n-1,DP));
}

int main(){
    String A,B;
    int m,n;
    scanf("%d %d",&m,&n);
    int DP[MAX][MAX];
    scanf("%s %s",A,B);
    for(int i=0;i<m+1;i++) for(int j=0;j<n+1;j++) DP[i][j] = -1;
    printf("%d\n",LCS(A,B,m,n,DP));
    return 0;
}