#include<stdio.h>
#define MAX 100

int isSafe(int maze[][MAX],int rows, int cols, int x, int y){
    if(x<rows && y<cols && maze[x][y]==1) return 1;
    return 0;
}

int backtrack(int maze[][MAX], int rows, int cols, int x, int y, int sol[][MAX]){
    if(x==rows-1 && y==cols-1){
        sol[x][y]=1;
        return 1;
    }
    if(isSafe(maze,rows,cols,x,y)==1){
        sol[x][y]=1;
        if(backtrack(maze,rows,cols,x+1,y,sol)==1){
            return 1;
        }
        if(backtrack(maze,rows,cols,x,y+1,sol)==1){
            return 1;
        }
        sol[x][y]=0;
        return 0;
    }
    return 0;
}

int main(){
    FILE* file = fopen("input.txt","r");

    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int maze[MAX][MAX];
        int sol[MAX][MAX];
        int rows, cols;
        fscanf(file, "%d %d",&rows, &cols);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                fscanf(file,"%d",&maze[i][j]);
                sol[i][j]=0;
            }
        }
        int res = backtrack(maze,rows,cols,0,0,sol);
        if(res>0){
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    printf("%d\t",sol[i][j]);
                }
                printf("\n");
            }
        } else {
            printf("Error\n");
        }
    }

    fclose(file);
    return 0;
}