#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAXC 256
#define MAX 100

/*
C++
Caratteri adiacenti: 8 (al massimo)
Numero di tentativi: rows*cols (al massimo)
Complessità = O(8^{rows*cols})
*/

// Attenzione, la traccia non impedisce di tornare indietro, quindi non controllo se si è già passati per una cella

typedef struct{
    int i;
    int j;
} position;

bool inBound(int x, int y, int rows, int cols){
    return (x>=0 && x<rows && y>=0 && y<cols);
}

void process_solution(position* pos, int dim){
    for(int i=0; i<dim; i++){
        printf("%d %d\n",pos[i].i+1,pos[i].j+1);
    }
}

void construct_candidates(char matrix[][MAX], int x, int y, int rows, int cols, int cursor, char* string, position* candidates, int* nc){
    char next = string[cursor+1];
    if(inBound(x-1,y-1,rows,cols) && matrix[x-1][y-1]==next){
        candidates[*nc].i=x-1;
        candidates[*nc].j=y-1;
        (*nc)++;
    }
    if(inBound(x-1,y,rows,cols) && matrix[x-1][y]==next){
        candidates[*nc].i=x-1;
        candidates[*nc].j=y;
        (*nc)++;
    }
    if(inBound(x-1,y+1,rows,cols) && matrix[x-1][y+1]==next){
        candidates[*nc].i=x-1;
        candidates[*nc].j=y+1;
        (*nc)++;
    }
    if(inBound(x,y-1,rows,cols) && matrix[x][y-1]==next){
        candidates[*nc].i=x;
        candidates[*nc].j=y-1;
        (*nc)++;
    }
    if(inBound(x,y+1,rows,cols) && matrix[x][y+1]==next){
        candidates[*nc].i=x;
        candidates[*nc].j=y+1;
        (*nc)++;
    }
    if(inBound(x+1,y-1,rows,cols) && matrix[x+1][y-1]==next){
        candidates[*nc].i=x+1;
        candidates[*nc].j=y-1;
        (*nc)++;
    }
    if(inBound(x+1,y,rows,cols) && matrix[x+1][y]==next){
        candidates[*nc].i=x+1;
        candidates[*nc].j=y;
        (*nc)++;
    }
    if(inBound(x+1,y+1,rows,cols) && matrix[x+1][y+1]==next){
        candidates[*nc].i=x+1;
        candidates[*nc].j=y+1;
        (*nc)++;
    }
}

bool backtrack(char matrix[][MAX], int x, int y, int rows, int cols, char* string, int cursor, position* sol){
    if(cursor==strlen(string)-1 && matrix[x][y]==string[cursor]){
        sol[cursor].i=x;
        sol[cursor].j=y;
        cursor++;
        process_solution(sol,cursor);
        return 1;
    }
    position candidates[8]; // Ci saranno tutti i possibili elementi adiacenti pari a string[cursor+1]
    int nc=0;
    construct_candidates(matrix,x,y,rows,cols,cursor,string,candidates,&nc);
    if(nc!=0){
        sol[cursor].i=x;
        sol[cursor].j=y;
        cursor++;
        for(int i=0; i<nc; i++){
            if(backtrack(matrix,candidates[i].i,candidates[i].j,rows,cols,string,cursor,sol)==1) return 1;
        }
        cursor--;
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
        int length = strlen(string);
        position positions[length];
        int rows, cols;
        char matrix[MAX][MAX];
        fscanf(file,"%d %d",&rows, &cols);

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                fscanf(file," %c",&matrix[i][j]);
            }
        }
        int broken=false;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j]==string[0]){ //inutile entrare se il primo carattere non è quello cercato
                    if(backtrack(matrix,i,j,rows,cols,string,0,positions)==1){
                        broken=true;
                        break;
                    }
                }
                if(broken) break;
            }
        }
        printf("END\n");
    }
    fclose(file);
    return 0;
}