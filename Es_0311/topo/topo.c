#include <stdio.h>

void printMatrix(int matrix[][100], int rows, int cols){ //Stampa
    for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            printf("%d ",matrix[i][j]);
        }
        printf("\n");
    }
}

int isPercorribile(int matrix[][100], int rows, int cols, int x, int y){ // Se c'è un 1 in [x][y] e siamo nei boundaries
    if(x>=0 && x<rows && y>=0 && y<cols && matrix[x][y]==1){
        return 1;
    }
    return 0;
}

int backtrack(int matrix[][100], int rows, int cols, int x, int y, int solution[][100]){
    if(x==rows-1 && y==cols-1){ // se siamo arrivati alla fine ritorna 1
        solution[x][y]=1;
        return 1;
    }
    if(isPercorribile(matrix,rows,cols,x,y)==1){ //verifico se l'elemento dove mi trovo è un 1, altrimenti non continuo
        // make move
        solution[x][y]=1; //pongo a 1 l'elemento corrente
        //backtrack
        if(backtrack(matrix,rows,cols,x+1,y,solution)==1){ //proseguo a dx
            return 1;
        }
        if(backtrack(matrix,rows,cols,x,y+1,solution)==1){ //proseguo in basso
            return 1;
        }
        // Unmake Move
        solution[x][y]=0; //se non sono uscito prima dalla funzione pongo 0
        return 0; // ritorno 0 a questa iterazione.
    }
    return 0; //se x,y è diverso da 1 già ritorno 0
}

void risolvi(int matrix[][100], int rows, int cols){
    int solution[rows][100];
    for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            solution[i][j]=0;
        }
    }
    // inizializzato il vettore delle soluzioni con tutti zeri, parto dall'inizio. Se termino stampo la soluzione
    if(backtrack(matrix,rows,cols,0,0,solution)==1){
        printMatrix(solution,rows,cols);
    }else{
        printf("Non c'e' soluzione\n");
    }
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

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                fscanf(file,"%d",&matrix[i][j]);
            }
        }
        risolvi(matrix,rows,cols);
        cases--;
    }
    fclose(file);
    return 0;
}