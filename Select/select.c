#include<stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int getRandom(int p, int r) {
    // Generate a random number between p and r
    return p + rand() % (r - p + 1);
}

int partition(int* A, int p, int r){
    int x = A[r];
    int i=p-1;
    int j=r+1;
    while (true)    {
        do{
            j-=1;
        } while(A[j]>x);
        do{
            i+=1;
        } while(A[i]<x);
        if(i<j){
            int temp = A[i];
            A[i]=A[j];
            A[j]=temp;
        } else {
            return j;
        }
    }
    
}

int randomizedPartition(int* A, int p, int r) {
    int i = getRandom(p, r);
    int temp = A[r];
    A[r] = A[i];
    A[i] = temp;
    return partition(A,p,r);
}

int MPartition(int* A, int p, int r, int m){
    int temp = A[r];
    A[r] = A[m];
    A[m] = temp;
    return partition(A,p,r);
}

void InsertionSort(int* arr, int dim){
    for(int j=1; j<dim; j++){
        int key = arr[j];
        int i=j-1;
        while(i>=0 && arr[i]>key){
            arr[i+1]=arr[i];
            i--;
        }
        arr[i+1]=key;
    }
}

int RandomizedSelect(int* A, int p, int r, int i){
    if(p==r){
        return A[p];
    }
    int q = randomizedPartition(A,p,r);
    int k=q-p+1;
    if(i==k){
        return A[q];
    } else if(i<k){
        return RandomizedSelect(A,p,q-1,i);
    } else {
        return RandomizedSelect(A,q+1,r,i-k);
    }
}

int Select(int* A, int p, int r, int i){
    int n = r-p+1;
    if(n<=5){
        InsertionSort(A+p,n);
        return A[p+i-1];
    }
    int* B = (int*)malloc(sizeof(int)*n);
    int j=0;
    for(int k=0; k<n/5; k++){
        InsertionSort(A+p+k*5,5);
        B[j]=A[p+k*5+2];
        j++;
    }
    if(n%5!=0){
        InsertionSort(A+p+(n/5)*5,n%5);
        B[j]=A[p+(n/5)*5+(n%5)/2];
        j++;
    }
    int x = Select(B,0,j-1,j/2);
    int q = MPartition(A,p,r,x);
    int k=q-p+1;
    if(i==k){
        return A[q];
    } else if(i<k){
        return Select(A,p,q-1,i);
    } else {
        return Select(A,q+1,r,i-k);
    }
}

int main(){

    int A[] = {23, 2, 1, 4, 5, 6, 7, 8, 9, 10,11,84, 43,256,34};
    int n = sizeof(A)/sizeof(int);
    int i = n;
    int result = Select(A,0,n-1,i);
    printf("%d\n",result);
    return 0;
}