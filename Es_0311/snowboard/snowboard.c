#include <stdio.h>
#include <string.h>

#define MAX 101

int dp[MAX][MAX];
int grid[MAX][MAX];
int R, C;

int max(int a, int b) {
   return (a > b) ? a : b;
}

int longestDecreasingPath(int i, int j) {
   if (i < 0 || j < 0 || i >= R || j >= C || grid[i][j] == 0)
       return 0;
   if (dp[i][j] != -1)
       return dp[i][j];
   int res = 1 + max(longestDecreasingPath(i-1, j),
                    longestDecreasingPath(i+1, j));
   res = max(res, 1 + longestDecreasingPath(i, j-1));
   res = max(res, 1 + longestDecreasingPath(i, j+1));
   dp[i][j] = res;
   return res;
}

int main() {
   int N;
   FILE* file = fopen("input.txt","r");
   fscanf(file,"%d", &N);
   while (N--) {
       char name[MAX];
       fscanf(file," %s %d %d", name, &R, &C);
       for (int i = 0; i < R; i++)
           for (int j = 0; j < C; j++)
               fscanf(file,"%d", &grid[i][j]);
       memset(dp, -1, sizeof(dp));
       int maxPath = 0;
       for (int i = 0; i < R; i++)
           for (int j = 0; j < C; j++)
               maxPath = max(maxPath, longestDecreasingPath(i, j));
       printf("%s: %d\n", name, maxPath);
   }
   return 0;
}
