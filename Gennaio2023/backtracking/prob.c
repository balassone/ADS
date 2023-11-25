#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAXC 256
#define MAX 100

typedef struct{
    int i;
    int j;
} position;

bool inBound(int x, int y, int rows, int cols){
    return (x>=0 && x<rows && y>=0 && y<cols);
}

void construct_candidates(char matrix[][MAX], int rows, int cols, int x, int y, char* string, int cursor, position candidates[], int* nc){
    char next=string[cursor+1];
    if(inBound(x-1,y-1,rows,cols) && matrix[x-1][y-1]==next){
        candidates[*(nc)].i=x-1;
        candidates[*(nc)].j=y-1;
        (*nc)++;
    }
    if(inBound(x-1,y,rows,cols) && matrix[x-1][y]==next){
        candidates[*(nc)].i=x-1;
        candidates[*(nc)].j=y;
        (*nc)++;
    }
    if(inBound(x-1,y+1,rows,cols) && matrix[x-1][y+1]==next){
        candidates[*(nc)].i=x-1;
        candidates[*(nc)].j=y+1;
        (*nc)++;
    }
    if(inBound(x,y-1,rows,cols) && matrix[x][y-1]==next){
        candidates[*(nc)].i=x;
        candidates[*(nc)].j=y-1;
        (*nc)++;
    }
    if(inBound(x,y+1,rows,cols) && matrix[x][y+1]==next){
        candidates[*(nc)].i=x;
        candidates[*(nc)].j=y+1;
        (*nc)++;
    }
    if(inBound(x+1,y-1,rows,cols) && matrix[x+1][y-1]==next){
        candidates[*(nc)].i=x+1;
        candidates[*(nc)].j=y-1;
        (*nc)++;
    }
    if(inBound(x+1,y,rows,cols) && matrix[x+1][y]==next){
        candidates[*(nc)].i=x+1;
        candidates[*(nc)].j=y;
        (*nc)++;
    }
    if(inBound(x+1,y+1,rows,cols) && matrix[x+1][y+1]==next){
        candidates[*(nc)].i=x+1;
        candidates[*(nc)].j=y+1;
        (*nc)++;
    }
}

void process_solution(position* array, int dim){
    for(int i=0; i<dim; i++){
        printf("%d %d\n",array[i].i+1,array[i].j+1);
    }
}

int backtrack(char matrix[][MAX], int rows, int cols, int x, int y, char string[], int cursor, position* array){
    if(cursor==strlen(string)-1){
        array[cursor].i=x;
        array[cursor].j=y;
        process_solution(array,cursor+1);
        return 1;
    }
    if(matrix[x][y]==string[cursor]){
        position candidates[8];
        int nc=0;
        construct_candidates(matrix,rows,cols,x,y,string,cursor,candidates,&nc);
        if(nc!=0){
            array[cursor].i=x;
            array[cursor].j=y;
            cursor++;
            for(int i=0; i<nc; i++){
                if(backtrack(matrix,rows,cols,candidates[i].i,candidates[i].j,string,cursor,array)==1) return 1;
            }
            cursor--;
            return 0;
        }
        return 0;
    }
    return 0;
}

int main(){
    FILE* file = fopen("input.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){

        char string[MAXC];
        fscanf(file,"%s",string);
        int rows, cols;
        fscanf(file,"%d %d", &rows, &cols);
        char matrix[MAX][MAX];
        //int solution[MAX][MAX];
        position array[MAX];
        /*
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                fscanf(file," %c",&matrix[i][j]);
                solution[i][j]=0;
            }
        }
        */
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(backtrack(matrix,rows,cols,i,j,string,0,array)==1) break;
            }
        }
        printf("END\n");
    }
    fclose(file);
    return 0;
}