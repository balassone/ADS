#include <stdio.h>
#include <stdlib.h>

// Function to perform counting sort on an array A with range k
void countingSort(int A[], int B[], int n, int k) {
    int count[k+1];

    for(int i=0; i<k+1; i++){
        count[i]=0;
    }

    // Count the occurrences of each element in A
    for (int i = 0; i < n; i++) {
        count[A[i]]++;
    }

    // Calculate the cumulative counts
    for (int i = 1; i <= k; i++) {
        count[i] += count[i - 1];
    }

    // Place elements from A into B in sorted order
    for (int i = n - 1; i >= 0; i--) {
        B[count[A[i]] - 1] = A[i];
        count[A[i]]--;
    }
}

int main() {
    int A[] = {4, 2, 2, 8, 3, 3};
    int n = sizeof(A) / sizeof(A[0]);
    int k = 8; // Range of values

    int B[n]; // Array to store the sorted result

    printf("Original array A: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", A[i]);
    }

    countingSort(A, B, n, k);

    printf("\nSorted array B: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", B[i]);
    }

    return 0;
}
