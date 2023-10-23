#include <stdio.h>
#include <string.h>

typedef char string[256];

void singleLCS(string A, int dimA, string B, int dimB, string* res){ // Costa O(n): unico ciclo for sulla dimensione della stringa minore.

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

void LCS(string* A, int p, int r, string* result){ // T(n)=2T(n/2)+O(n), è Theta(n log n) per metodo dell'esperto
    if(r<p) return;
    if(r-p==0){
        memcpy(*(result),A[p],sizeof(A[0]));
    }
    if(p<r){
        int q = (p+r)/2;
        string L,R,res;
        LCS(A,p,q,&L);
        LCS(A,q+1,r,&R);
        singleLCS(L,strlen(L),R,strlen(R),&res);
        memcpy(*(result),res,sizeof(res));
    }
}

int main(){
    
    FILE* file = fopen("input.txt","r");
    int cases;
    fscanf(file,"%d",&cases);
    while(cases>0){
        int i=0;
        string strs[100];
        while(fscanf(file,"%s",strs[i])>0 && strcmp(strs[i],"STOP")!=0){
            i++;
        }
        string subsequence;
        LCS(strs,0,i-1,&subsequence);
        printf("%s\n",subsequence);
        cases--;
    }
    fclose(file);
    
    
    return 0;
}