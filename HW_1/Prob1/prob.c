#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int merge(int* A, int p, int q, int r){ // Costa O(n)
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
            scambi += n1-i; // sto "scavalcando" tutti gli n1-i elementi che rimangono in L per inserire R[j], dove i è l'indice associato alla posizione dove andrà il mio elemento
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

int MergeSort(int* A, int p, int r){ // T(n)=2T(n/2) + O(n): costa O(n log n)
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