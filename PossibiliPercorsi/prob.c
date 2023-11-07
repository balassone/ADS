#include <stdio.h>
#include <stdbool.h>
#define MAX 100

void printArray(int A[], int dim){
    for(int i=0; i<dim; i++){
        printf("%d\t",A[i]);
    }
    printf("\n");
}

bool inBound(int x, int y, int rows, int cols){
    return (x<rows && y<cols);
}

void backtrack(int matrix[][MAX], int rows, int cols, int x, int y, int array[], int dim){
    if(x==rows-1 && y==cols-1){
        array[dim]=matrix[x][y];
        dim++;
        printArray(array,dim);
    }
    if(inBound(x,y,rows,cols)){
        array[dim]=matrix[x][y];
        backtrack(matrix,rows,cols,x+1,y,array,dim+1);
        backtrack(matrix,rows,cols,x,y+1,array,dim+1);
    }
    return;
}

int main(){
    FILE* file = fopen("input.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int rows, cols;
        int matrix[MAX][MAX];
        int array[MAX];
        fscanf(file, "%d %d",&rows, &cols);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                fscanf(file,"%d",&matrix[i][j]);
            }
        }
        backtrack(matrix,rows,cols,0,0,array,0);
    }
    fclose(file);
    return 0;
}