#include <stdio.h>

void minmax(int A[], int n, int *min, int *max) {

    int low, high;

    if (n % 2 == 0) {
        if (A[0] < A[1]) {
            *(min) = A[0];
            *(max) = A[1];
        } else {
            *(min) = A[1];
            *(max) = A[0];
        }
    } else {
        *(min) = *(max) = A[0];
    }

    for(int i=1; i<=(n+1)/2; i++){
        if(A[2*i-1-n%2]<A[2*i-n%2]){
            low=A[2*i-1-n%2];
            high=A[2*i-n%2];
        } else {
            low=A[2*i-n%2];
            high=A[2*i-1-n%2];
        }

        if(low<*(min)){
            *(min)=low;
        }
        if(high>*(max)){
            *(max)=high;
        }
    }

    
    
}

int main() {
    int A[] = {1, 2, 7,24, 3, 4, 5,19};
    int n = sizeof(A) / sizeof(int);
    int min, max;
    minmax(A, n, &min, &max);
    printf("Minimo: %d\n", min);
    printf("Massimo: %d\n", max);
    return 0;
}
