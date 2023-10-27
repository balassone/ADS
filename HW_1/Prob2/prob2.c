#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef char string[256];

void singleLCP(string A, int dimA, string B, int dimB, string* res){ // Costa O(l): unico ciclo for sulla lunghezza della stringa minore.

    string result;
    int dim = dimA<dimB ? dimA : dimB;
    int count=0;

    for(int i=0; i<dim; i++){
        if(A[i]==B[i]){
            count++;
        } else {
            break;
        }
    }

    memcpy(result,A,count);
    result[count]='\0';
    memcpy(*(res),result,sizeof(result));
}

void LCP(string* A, int p, int r, string* result){ // T(n)=2T(n/2)+O(l), è Theta(l log n), dove n è il numero di stringhe in A
    if(r<p) return;
    if(r-p==0){
        memcpy(*(result),A[p],sizeof(A[0]));
    }
    if(p<r){
        int q = (p+r)/2;
        string L,R,res;
        LCP(A,p,q,&L);
        LCP(A,q+1,r,&R);
        singleLCP(L,strlen(L),R,strlen(R),&res);
        memcpy(*(result),res,sizeof(res));
        
    }
}

int main(){
    
    FILE* file = fopen("input.txt","r");
    int cases;
    fscanf(file,"%d",&cases);
    while(cases>0){
        int i=0;
        int dim = 50;
        string* strs = (string*) malloc(dim*sizeof(string));
        while(fscanf(file,"%s",strs[i])>0 && strcmp(strs[i],"END")!=0){
            i++;
        }
        string subsequence;
        LCP(strs,0,i-1,&subsequence);
        printf("%s\n",subsequence);
        free(strs);
        cases--;
    }
    fclose(file);
    
    
    return 0;
}