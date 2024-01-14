#include <stdio.h>
#include <stdbool.h>

int min(int a, int b,int c){
    int min= a<b?a:b;
    return c<min?c:min;
}

bool inBound(int i, int j, int m, int n){
    return (i>=0 && j>=0 && i<m && j<n);
}

int minCost(int matrix[][100], int dp[][100],int i, int j, int m, int n){
    
    

}

int main(){
    int m, n;
    scanf("%d %d",&m,&n);
    int matrix[m][n];
    int DP[m][n];
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            scanf("%d",&matrix[i][j]);
            DP[i][j]=0;
        }
    }
    DP[0][0]=1;
}