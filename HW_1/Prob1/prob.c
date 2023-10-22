/*
Si richiede di analizzare un particolare algoritmo di ordinamento. 

L'algoritmo elabora una
sequenza di n interi distinti scambiando due elementi adiacenti finché la sequenza non viene
ordinata in ordine crescente.

La lunghezza massima della sequenza di input è n < 500.000.


Per la sequenza di input: 91054, l’algoritmo produce l'output 01459.


Bisogna determinare quante operazioni di scambio sono necessarie a quest’algoritmo per
ordinare una determinata sequenza di input.

Un modo alternativo di vedere è il problema è in termini di “inversioni”: in una sequenza A,
la coppia (i, j) è un’inversione se i < j e Ai > Aj. Il problema consiste nel trovare il 
conteggio delle inversioni.

Divide et impera


*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int inversionCounter(int* A,int p,int r){
    if(r-p<=1){
        return 0;
    } else if (r-p==2){
        if(A[p]>A[r-1]){
            int temp = A[r-1];
            A[r-1]=A[p];
            A[p]=temp;
            return 1;
        }
        return 0;
    } else {
        
        return inversionCounter(A,p,r-1) + inversionCounter(A,p+1,r) + inversionCounter(A,p+1,r-1) + inversionCounter(A,0,2);
    }
}

int main(){
    FILE* file = fopen("input.txt", "r");
    int length;
    fscanf(file,"%d",&length);
    while(length!=0){
        int A[length];
        for(int i=0; i<length; i++){
            fscanf(file,"%d",&A[i]);
        }
        printf("%d\n",inversionCounter(A,0,length));
        //for(int i=0; i<length; i++){
          //  printf("%d\t",A[i]);
            
        //}
        //printf("\n");
        fscanf(file,"%d",&length);
    } 
    fclose(file);
    
    return 0;
}