#include <stdio.h>
#include <stdbool.h>
int partition(int A[], int p, int r){
    int k = A[r];
    int i=p-1;
    int j=r+1;
    while(true){
        do{
            j--;
        } while(A[j]>k);
        do{
            i++;
        } while(A[j]<k);
        if(i<j){
            int temp = A[j];
            A[j]=A[i];
            A[i]=temp;
        } else{
            return j;
        }
    }
}

void QuickSort(int A[], int p, int r){
    if(p<r){
        int q = partition(A,p,r);
        QuickSort(A,p,q);
        QuickSort(A,q+1,r);
    }
}

int binSearch(int A[], int p, int r, int k){
    if(p<=r){
        int q = (p+r)/2;
        if(A[q]==k) return q;
        else if(A[q]<k){
            return binSearch(A,q+1,r,k);
        } else{
            return binSearch(A,p,q-1,k);
        }
    }
    return -1;
}

int main(){
    FILE* file = fopen("input.txt","r");
    int N, Q;
    int i=1;
    fscanf(file,"%d %d",&N, &Q);
    do{
        int A[N];
        for(int i=0; i<N; i++){
            fscanf(file,"%d",&A[i]);
        }
        printf("CASE# %d:\n",i);
        QuickSort(A,0,N-1);
        for(int i=0;i<Q; i++){
            int number;
            fscanf(file,"%d",&number);
            
            int pos = binSearch(A,0,N-1,number);
            if(pos!=-1){
                printf("%d found at %d\n",number,pos+1);
            } else {
                printf("%d not found\n",number);
            }
        }
        fscanf(file,"%d %d",&N, &Q);
        i++;
    } while(N!=0 && Q!=0);
    fclose(file);
    return 0;
}