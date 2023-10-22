#include <stdio.h>
void MaxHeapify(int* A, int dim, int i){
    int l=2*i+1;
    int r=2*i+2;
    int largest = i;
    if(l<dim && A[l]>A[largest]){
        largest=l;
    }
    if(l<dim && A[r]>A[largest]){
        largest=r;
    }
    if(largest != i){
        int temp = A[i];
        A[i]=A[largest];
        A[largest]=temp;
        MaxHeapify(A,dim,largest);
    }
}

void BuildMaxHeap(int* A, int dim){
    for(int i=(dim/2); i>=0; i--){
        MaxHeapify(A,dim,i);
    }
}

void HeapSort(int* A, int dim){
    BuildMaxHeap(A,dim);
    for(int i=dim-1; i>0; i--){
        int temp = A[0];
        A[0]=A[i];
        A[i]=temp;
        MaxHeapify(A,dim,0);
    }
}

// Heap Priority Queue

int HeapMaximum(int* A, int dim){
    if(dim>0){
        return A[0];
    }
}

int HeapExtractMax(int* A, int* dim){
    if(*dim<1){
        perror("Heap Vuoto!");
    } else {
        int max = A[0];
        A[0]=A[*dim-1];
        (*dim)--;
        MaxHeapify(A,*dim,0);
        return max;
    }
}

void maxHeapIncreaseKey(int arr[], int n, int i, int newKey) {
    if (i >= n) {
        printf("Index out of bounds.\n");
        return;
    }

    if (newKey < arr[i]) {
        printf("New key is smaller than the current key.\n");
        return;
    }

    arr[i] = newKey;

    
    while (i > 0 && arr[(i - 1) / 2] < arr[i]) {

        int temp = arr[i];
        arr[i] = arr[(i - 1) / 2];
        arr[(i - 1) / 2] = temp;

        i = (i - 1) / 2;
    }
}

void MaxHeapInsert(int* A, int* n, int key){
    (*n)++;
    A[*n-1]=key;
    maxHeapIncreaseKey(A,*n,*n,key);
}