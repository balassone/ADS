#include <stdio.h>
#include <stdlib.h>

int max(int a, int b){
    return a>b?a:b;
}

typedef char String[256];

int lcs(String A, String B, int m, int n){
    int DP[m+1][n+1];
    for(int i=0; i<m+1; i++){
        for(int j=0; j<n+1; j++){
            DP[i][j]=0;
        }
    }

    for(int i=0; i<m+1; i++){
        for(int j=0; j<n+1; j++){
            if(i==0 || j==0) DP[i][j]=0;
            else if(A[i-1]==B[j-1]) DP[i][j]=DP[i-1][j-1]+1;
            else DP[i][j]=max(DP[i-1][j],DP[i][j-1]);
        }
    }
}

int main(){
    String A,B;
    int m,n;
    scanf("%d %d",&m,&n);
    scanf("%s %s",A,B);
    printf("%d\n",lcs(A,B,m,n));
    return 0;
}