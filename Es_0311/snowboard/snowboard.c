#include <stdio.h>
#include <stdbool.h>
#define MAXS 256
#define MAX 100

typedef struct {
    int i;
    int j;
} neighbor;


bool inBound(int i, int j, int rows, int cols){
    return (i>=0 && i<rows && j>=0 && j<cols);
}

void build_neighbors(int matrix[][MAX],int rows, int cols, int x, int y,neighbor* neighbors, int* nneighbors){
    if(inBound(x-1,y,rows,cols) && matrix[x-1][y]<matrix[x][y]){
        neighbors[*nneighbors].i=x-1;
        neighbors[*nneighbors].j=y;
        (*nneighbors)++;
    }
    if(inBound(x,y-1,rows,cols) && matrix[x][y-1]<matrix[x][y]){
        neighbors[*nneighbors].i=x;
        neighbors[*nneighbors].j=y-1;
        (*nneighbors)++;
    }
    if(inBound(x,y+1,rows,cols) && matrix[x][y+1]<matrix[x][y]){
        neighbors[*nneighbors].i=x;
        neighbors[*nneighbors].j=y+1;
        (*nneighbors)++;
    }
    if(inBound(x+1,y,rows,cols) && matrix[x+1][y]<matrix[x][y]){
        neighbors[*nneighbors].i=x+1;
        neighbors[*nneighbors].j=y;
        (*nneighbors)++;
    }
}

int backtrack(int matrix[][MAX], int rows, int cols, int x, int y){
    neighbor neighbors[4];
    int nneighbors=0;
    build_neighbors(matrix,rows,cols,x,y,neighbors,&nneighbors);
    if(nneighbors==0){
        return 1;
    } else {
        int a;
        int max = -1;
        for(int i=0; i<nneighbors; i++){
            a=1+backtrack(matrix,rows,cols,neighbors[i].i,neighbors[i].j);
            if(a>max){
                max=a;
            }
        }
        return max;
    }
    return 1;

}

int main(){
    FILE* file = fopen("input.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        char pista[MAXS];
        fscanf(file,"%s",pista);
        int matrix[MAX][MAX];
        int rows, cols;
        fscanf(file,"%d %d",&rows, &cols);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                fscanf(file,"%d",&matrix[i][j]);
            }
        }
        int max=-1;
        int a;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                a = backtrack(matrix,rows,cols,i,j);
                if(a>max){
                    max=a;
                }
            }
        }
        printf("%s: %d\n",pista,max);
    }
    fclose(file);
    return 0;
}