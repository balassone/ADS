#include <stdio.h>

void minmax(int A[], int n, int *min, int *max) {
    if (n % 2 == 0) {
        if (A[0] < A[1]) {
            *min = A[0];
            *max = A[1];
        } else {
            *min = A[1];
            *max = A[0];
        }
    } else {
        *min = *max = A[0];
    }

    for (int i = 2; i < n; i ++) {
        int small, big;
        if (A[i] < A[i + 1]) {
            small = A[i];
            big = A[i + 1];
        } else {
            small = A[i + 1];
            big = A[i];
        }

        if (small < *min) {
            *min = small;
        }
        if (big > *max) {
            *max = big;
        }
    }
}

int main() {
    int A[] = {1, 2, 3, 4, 5};
    int min, max;
    minmax(A, 5, &min, &max);
    printf("Minimo: %d\n", min);
    printf("Massimo: %d\n", max);
    return 0;
}
