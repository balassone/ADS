#include <stdio.h>
#include <stdbool.h>
#define MAX 100

bool possiblePosition(int matrix[][MAX], int N, int x, int y) {
    
    for (int i = 0; i < N; i++) {
        if (matrix[x][i] == 1) {
            return false;
        }
    }

    for (int i = 0; i < N; i++) {
        if (matrix[i][y] == 1) {
            return false; 
        }
    }
    
    for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
        if (matrix[i][j] == 1) {
            return false; 
        }
    }

    for (int i = x, j = y; i >= 0 && j < N; i--, j++) {
        if (matrix[i][j] == 1) {
            return false; 
        }
    }

    for (int i = x, j = y; i < N && j >= 0; i++, j--) {
        if (matrix[i][j] == 1) {
            return false;
        }
    }

    for (int i = x, j = y; i < N && j < N; i++, j++) {
        if (matrix[i][j] == 1) {
            return false;
        }
    }

    return true;
}


void build_candidates(int matrix[][MAX], int N, int* candidates, int* nc, int placed){
    for(int i=0; i<N; i++){
        if(possiblePosition(matrix,N,i,placed)){
            candidates[*nc]=i;
            (*nc)++;
        }
    }
}



int backtrack(int matrix[][MAX], int N, int placed){
    if(placed==N){
        return 1;
    }
    int candidates[N];
    int nc=0;
    build_candidates(matrix,N,candidates,&nc,placed);
    int count=0;
    for(int i=0; i<nc; i++){
        matrix[candidates[i]][placed]=1;
        placed++;
        count += backtrack(matrix,N,placed);
        placed--;
        matrix[candidates[i]][placed]=0;
    }
    return count;
}

int main(){
    FILE* file = fopen("input.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int N;
        fscanf(file,"%d",&N);
        int matrix[MAX][MAX];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                matrix[i][j]=0;
            }
        }
        int val = backtrack(matrix,N,0);
        printf("%d\n",val);
    }
    return 0;
}