#include<stdio.h>

void BubbleSort(int* A, int dim){
    int n = dim-1;
    int lastChange = n;
    while(lastChange>0){
        lastChange=0;
        for(int i=0; i<n; i++){
            if(A[i]>A[i+1]){
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1]=temp;
                lastChange=i;
            }
        }
        n=lastChange;
    }
}

int main(){
    int A[] = {27,49,-91,8,14,23,4};
    int dim = 7;
    BubbleSort(A,dim);
    for(int i=0; i<dim; i++){
        printf("%d\t",A[i]);
    }
    return 0;
}