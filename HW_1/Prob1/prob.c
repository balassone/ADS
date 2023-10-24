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

int merge(int* A, int p, int q, int r){
    int n1 = q-p+1;
    int n2 = r-q;
    int L[n1], R[n2];
    int i,j,k,scambi=0;
    for(i=0; i<n1; i++){
        L[i]=A[p+i];
    } for (j=0; j<n2; j++){
        R[j]=A[q+1+j];
    }

    i=j=0;
    k=p;
    while(i<n1 && j<n2){
        int val;
        if(L[i]<=R[j]){ //non voglio scambiare elementi uguali
            A[k] = L[i];
            i++;
        } else {
            A[k] = R[j];
            j++;
            scambi += n1-i; // sto "scavalcando" tutti gli n1-1 elementi che rimangono in L per inserire R[j]
        }
        k++;
    }
    while(i<n1){
        A[k++]=L[i++];
    }
    while(j<n2){
        A[k++]=R[j++];
    }
    return scambi;
}

int MergeSort(int* A, int p, int r){
    int scambi=0;
    if(p<r){
        int q = (p+r)/2;
        scambi+=MergeSort(A,p,q);
        scambi+=MergeSort(A,q+1,r);
        scambi+=merge(A,p,q,r);
    }
    return scambi;
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
        printf("%d\n",MergeSort(A,0,length-1));
        fscanf(file,"%d",&length);
    } 
    fclose(file);
    return 0;
}