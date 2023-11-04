#include <stdio.h>

void backtrack(int a[][100], int rows, int cols, int x, int y, int input[][100]){

}

int main(){
    FILE* file = fopen("input.txt","r");
    int cases;
    fscanf(file,"%d",&cases);
    while(cases>0){
        
        int rows, cols;
        fscanf(file,"%d",&rows);
        fscanf(file,"%d",&cols);
        int matrix[100][100];
        int sol[100][100];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                fscanf(file,"%d",&matrix[i][j]);
                sol[i][j]=0;
            }
        }
        backtrack(sol,rows,cols,0,0,matrix);
        cases--;
    }
    fclose(file);
    return 0;
}