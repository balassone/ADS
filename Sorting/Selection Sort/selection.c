#include<stdio.h>

void SelectionSort(int* A, int dim){
    for(int i=0; i<dim-1; i++){
        int min = i;
        for(int j=i+1; j<dim; j++){
            if(A[j]<A[min]){
                min=j;
            }
        }
        if(min!=i){
            int temp=A[i];
            A[i]=A[min];
            A[min]=temp;
        }
    }
}

int main(){
    int A[] = {12,34,-6,-8,45,2,66};
    int dim = 7;
    SelectionSort(A,dim);
    for(int i=0; i<dim; i++){
        printf("%d\t",A[i]);
    }
}