#include<stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int getRandom(int p, int r) {
    // Generate a random number between p and r
    return p + rand() % (r - p + 1);
}

int randomizedPartition(int* A, int p, int r) {
    int i = getRandom(p, r); // Randomly select a pivot index
    int temp = A[r];
    A[r] = A[i];
    A[i] = temp;
    
    int x = A[r];
    i = p - 1;

    for (int j = p; j <= r - 1; j++) {
        if (A[j] <= x) {
            i++;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    
    temp = A[i + 1];
    A[i + 1] = A[r];
    A[r] = temp;

    return i + 1;
}

int partition(int* A, int p, int r){
    int x = A[p];
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

void QuickSort(int* A, int p, int r){
    if(p<r){
        int q = partition(A,p,r);
        QuickSort(A,p,q);
        QuickSort(A,q+1,r);
    }
}